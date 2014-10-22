package com.geminisystems.subscription.job;

import com.geminisystems.subscription.dao.CategoryDao;
import com.geminisystems.subscription.dao.SubscriptionDao;
import com.geminisystems.subscription.domain.SBean;
import com.geminisystems.subscription.domain.SCategory;
import com.geminisystems.subscription.domain.SPath;
import com.geminisystems.subscription.domain.SType;
import com.geminisystems.subscription.service.MailService;
import com.geminisystems.subscription.service.ServletContextProvider;
import com.geminisystems.subscription.service.WcmService;
import com.ibm.workplace.wcm.api.*;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 14.11.2011
 * Time: 14:00:52
 * To change this template use File | Settings | File Templates.
 */
public class SendUsersMailJob extends QuartzJobBean {

    private final static String PROP_LAST_EXECUTION_TIME = "last.execution.time";
    private final static String PROP_DENY_JOBS_HOST = "subscr.deny.jobs.host";
    private final static DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    private ServletContextProvider contextProvider;
    private Logger logger = Logger.getLogger(SendUsersMailJob.class);
    private Properties schedulerProperites;
    private Properties configProperites;
    private WcmService wcmService;
    private CategoryDao categoryDao;
    private SubscriptionDao daoService;
    private MailService mailService;


    @Override
    protected void executeInternal(org.quartz.JobExecutionContext jobExecutionContext) throws JobExecutionException {

        try {
            String denyHost = configProperites.getProperty(PROP_DENY_JOBS_HOST);
            if (denyHost.equalsIgnoreCase(InetAddress.getLocalHost().getHostName())) {
                logger.info("ATTEMP TO RUN SEND USER MAIL UPDATES JOB AT DENIED HOST : " + InetAddress.getLocalHost().getHostName());
                return;
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        logger.setLevel(Logger.getRootLogger().getLevel());
        logger.info("=================================================================================");
        logger.info("Send USERS updates job started...");

        String lastTime = schedulerProperites.getProperty(PROP_LAST_EXECUTION_TIME);

        if (lastTime == null) {
            printLogFooter("Can't find last execution time property in scheduler.properties");
            return;
        }

        Date from = null;
        try {
            from = df.parse(lastTime);
        } catch (ParseException e) {
            printLogFooter("Bad format last execution time property in scheduler.properties, must be dd.MM.yyyy HH:mm:ss" + "\n" + e.getMessage());
            return;
        }
        Date to = new Date();
        if (from.after(to)) {
            printLogFooter("Invalid date in scheduler.properties, must be before then " + df.format(to));
            return;
        }

        logger.info("Get modified content from WCM between " + df.format(from) + " and " + df.format(to));
        List<Content> modifiedContent = wcmService.getModifiedContent(from, to);

        if (modifiedContent == null || modifiedContent.isEmpty()) {
            printLogFooter("Can't get modified content from WCM or modified content not found");
            return;
        }

        logger.info("Obtained " + modifiedContent.size() + " modified content items");
        List<SBean> subscribers = daoService.getAllActive(SType.USERS);

        if (subscribers == null || subscribers.isEmpty()) {
            printLogFooter("Can't get subscribers list from database");
            return;
        }


        Map<String, List<Content>> newContentForAreas = new HashMap<String, List<Content>>();
        int count = 0;
        for (SBean b : subscribers) {

            Map<String, List<String>> data = new HashMap<String, List<String>>();

            for (SCategory category : b.getCategories()) {
                category = categoryDao.getById(category.getCategoryId());
                // String[] areas = category.getPath().split(",");
                List<String> contentData = new ArrayList<String>();
                for (SPath spath : category.getPaths()) {
                    // for (int i = 0; i < areas.length; i++) {
                    //  String path = areas[i];
                    //String path = spath.getPathValue();

                    String path = "Web Content" + spath.getPathValue().substring(11, spath.getPathValue().length());
                    if (newContentForAreas.get(path) == null) {
                        logger.info("Get modifies content from " + path + " area");
                        List<Content> newContent = wcmService.getNewContentByArea(modifiedContent, category, path);
                        newContentForAreas.put(path, newContent);
                        if (newContent == null || newContent.isEmpty()) {
                            logger.info("Modified content in " + path + " area not found");
                            continue;
                        }
                        logger.info("Obtained " + newContent.size() + " modified content items from " + path + " area");

                    }

                    List<Content> lc = newContentForAreas.get(path);

                    if (lc != null && !lc.isEmpty()) {

                        for (Content content : lc) {
                            String url = configProperites.getProperty("portal.host") + "/?urile=wcm:path:/" + path.replaceAll(" ", "%20") + "/" + content.getName();

                            String fields[] = content.getComponentNames();
                            String title = null;
                            String descr = null;
                            for (String s : fields) {
                                try {
                                    if (s.equals("title"))
                                        title = ((TextComponent) content.getComponent(s)).getText();
                                    else if (s.equals("description"))
                                        descr = ((TextComponent) content.getComponent(s)).getText();
                                    else
                                        continue;
                                } catch (Exception e) {

                                }
                            }


                            if (title == null) title = content.getTitle();
                            if (descr != null)
                                descr = "<br/>" + descr;
                            else
                                descr = "";
                            String link = "<a href='" + url + "'>" + title + "</a>" + descr;
                            contentData.add(link);
                        }
                    }
                    // }
                }
                if (!contentData.isEmpty())
                    data.put(category.getTitle(), contentData);
            }

            if (!data.isEmpty()) {
                logger.debug("Send mail to " + b.getEmail());
                boolean result = mailService.sendUpdatesMail(b, data);
                if (result) count++;
            }
        }


        schedulerProperites.setProperty(PROP_LAST_EXECUTION_TIME, df.format(to));
        try {
            String path = contextProvider.getContext().getRealPath("/WEB-INF/scheduler.properties");
            schedulerProperites.store(new FileOutputStream(path), null);
        } catch (IOException e) {
            printLogFooter("Can't modify last update time in scheduler.properties " + "\n" + e.getMessage());
            return;
        }
        logger.info("It was sent " + count + " emails");
        logger.info("Send updates job finished...");
        logger.info("=================================================================================");

    }

    public void setWcmService(WcmService wcmService) {
        this.wcmService = wcmService;
    }

    public void setDaoService(SubscriptionDao daoService) {
        this.daoService = daoService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }


    public void setSchedulerProperites(Properties schedulerProperites) {
        this.schedulerProperites = schedulerProperites;
    }

    public void setConfigProperites(Properties configProperites) {
        this.configProperites = configProperites;
    }

    public void setContextProvider(ServletContextProvider contextProvider) {
        this.contextProvider = contextProvider;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    private void printLogFooter(String error) {
        logger.info(error);
        logger.info("Send updates job finished...");
        logger.info("=================================================================================");
    }

}
