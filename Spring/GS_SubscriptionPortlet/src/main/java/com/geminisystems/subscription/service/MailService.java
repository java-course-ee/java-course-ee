package com.geminisystems.subscription.service;

import com.geminisystems.subscription.domain.SBean;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 16.11.2011
 * Time: 11:32:49
 * To change this template use File | Settings | File Templates.
 */


public class MailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private VelocityEngine velocityEngine;
    @Autowired
    @Qualifier("messageSource")
    private MessageSource messages;

    private Properties configProperites;

    public boolean sendConfirmMail(SBean bean, String action) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            message.setSubject(getMessage("subscription.subject"), "UTF-8");
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(bean.getEmail().toLowerCase()));
            message.setFrom(new InternetAddress(getMessage("subscription.from")));
            Map model = new HashMap();
            model.put("subscribe_link", composeLink(bean, SubscriptionService.ACTION_SUBSCRIBE));
            String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/WEB-INF/templates/subscribe.vm", "UTF-8", model);
            message.setContent(text, "text/html;charset=utf-8");
            this.mailSender.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean sendUpdatesMail(SBean bean, Map<String, List<String>> data) {
        try {

            MimeMessage message = mailSender.createMimeMessage();
            message.setSubject(getMessage("subscription.subject"), "UTF-8");
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(bean.getEmail()));
            message.setFrom(new InternetAddress(getMessage("subscription.from")));
            Map model = new HashMap();
            model.put("edit_link", composeLink(bean, SubscriptionService.ACTION_UNSUBSCRIBE));
            model.put("data", data);
            String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/WEB-INF/templates/updates.vm", "UTF-8", model);
            message.setContent(content, "text/html;charset=utf-8");
            this.mailSender.send(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String getMessage(String key) {
        return messages.getMessage(key, null, new Locale("RU"));
    }

    public String composeLink(SBean bean, String action) {
        String link = configProperites.getProperty("portal.host") + "/" +
                configProperites.getProperty("subscr.page.unique.name") +
                "?action=" + action + "&email=" + bean.getEmail() + "&rnd=" + bean.getHash();
        return link;
    }


    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public void setMessages(MessageSource messages) {
        this.messages = messages;
    }

    public void setConfigProperites(Properties configProperites) {
        this.configProperites = configProperites;
    }
}
