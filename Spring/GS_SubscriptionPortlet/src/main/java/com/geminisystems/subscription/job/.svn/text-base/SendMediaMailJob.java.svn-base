package com.geminisystems.subscription.job;

import com.geminisystems.subscription.dao.CategoryDao;
import com.geminisystems.subscription.dao.SubscriptionDao;
import com.geminisystems.subscription.domain.SBean;
import com.geminisystems.subscription.domain.SCategory;
import com.geminisystems.subscription.domain.SMediaContent;
import com.geminisystems.subscription.domain.SType;
import com.geminisystems.subscription.service.MailService;
import com.geminisystems.subscription.service.MediaContentService;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 15.08.2012
 * Time: 13:23:10
 * To change this template use File | Settings | File Templates.
 */
public class SendMediaMailJob extends QuartzJobBean {

    private final static String PROP_DENY_JOBS_HOST = "subscr.deny.jobs.host";

    private Logger logger = Logger.getLogger(SendMediaMailJob.class);
    private SubscriptionDao subscriptionDao;
    private MailService mailService;
    private CategoryDao categoryDao;
    private MediaContentService mediaContentService;
    private Properties configProperites;



    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

         try {
            String denyHost = configProperites.getProperty(PROP_DENY_JOBS_HOST);
            if (denyHost.equalsIgnoreCase(InetAddress.getLocalHost().getHostName())) {
                logger.info("ATTEMP TO RUN SEND MEDIA UPDATES JOB AT DENIED HOST : " + InetAddress.getLocalHost().getHostName());
                return;
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


        logger.setLevel(Logger.getRootLogger().getLevel());
        logger.info("=================================================================================");
        logger.info("Send MEDIA updates job started...");


        logger.info("Get media content subscribers");
        List<SBean> subscribers = subscriptionDao.getAllActive(SType.MEDIA);

        logger.info("Get media content from database");
        List<SMediaContent> content = mediaContentService.getAll();
        logger.info("Obtained " + content.size() + " media content items");

        // create content map by category
        Map<String, List<String>> data = new HashMap<String, List<String>>();
        for (SMediaContent smc : content) {
            if (data.get(smc.getTitle()) == null) {
                data.put(smc.getTitle(), new ArrayList<String>());
            }
            // compose link
            String url = configProperites.getProperty("portal.host") + "/?urile=wcm:path:/" + smc.getUrl();
            String link = "<a href='" + url + "'>" + smc.getText() + "</a><br/>" + smc.getDescription();
            data.get(smc.getTitle()).add(link);
        }
        int count = 0;
        for (SBean b : subscribers) {
            Map<String, List<String>> userContent = new HashMap<String, List<String>>();
            for (SCategory category : b.getCategories()) {
                category = categoryDao.getById(category.getCategoryId());
                if (data.get(category.getTitle()) != null) {
                    userContent.put(category.getTitle(), data.get(category.getTitle()));
                }
            }
            if (!userContent.isEmpty()) {
                logger.debug("Send mail to " + b.getEmail());
                mailService.sendUpdatesMail(b, userContent);
                count++;
            }
        }


        logger.info("It was sent " + count + " MEDIA emails");
        logger.info("Send MEDIA updates job finished...");
        logger.info("=================================================================================");


        // delete all records
        mediaContentService.deleteAll(content);

    }

    public void setConfigProperites(Properties configProperites) {
        this.configProperites = configProperites;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public void setMediaContentService(MediaContentService mediaContentService) {
        this.mediaContentService = mediaContentService;
    }

    public void setSubscriptionDao(SubscriptionDao subscriptionDao) {
        this.subscriptionDao = subscriptionDao;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    private void printLogFooter(String error) {
        logger.info(error);
        logger.info("Send updates job finished...");
        logger.info("=================================================================================");
    }
}
