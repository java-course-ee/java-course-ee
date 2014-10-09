package com.geminisystems.subscription.service;

import com.geminisystems.subscription.dao.SubscriptionDao;
import com.geminisystems.subscription.domain.SBean;
import com.geminisystems.subscription.util.SResult;
import com.geminisystems.subscription.util.SubscriptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 07.11.2011
 * Time: 13:26:24
 * To change this template use File | Settings | File Templates.
 */
public class SubscriptionService {

    public static final String ACTION_SUBSCRIBE = "subscribe";
    public static final String ACTION_UNSUBSCRIBE = "unsubscribe";

    @Autowired
    private SubscriptionDao dao;
    @Autowired
    private MailService mail;
    @Autowired
    @Qualifier("messageSource")
    private MessageSource messages;


    public boolean isEmailExists(String email) {
        return dao.getByEmail(email) != null;
    }

    public SBean getByEmail(String email) {
        return dao.getByEmail(email);
    }

    public boolean isActiveSubscription(SBean b) {
        SBean bean = dao.getByEmail(b.getEmail().toLowerCase());
        if (bean == null) return false;
        return bean.isActive();
    }


    public SResult subscribe(SBean b, String action) {
        SResult result = new SResult();
        SBean bean = dao.getByEmail(b.getEmail());


        // subscription exists and status is active
        if (bean != null && bean.isActive()) {
            result.setMessage(getMessage("subscription.subscribe.failure"));
            result.setReason(getMessage("subscription.email.exists"));

            // subscription exists and status is inactive, confirm link
        } else if (bean != null && !bean.isActive()) {
            dao.update(bean);
            result.setSuccess(mail.sendConfirmMail(bean, ACTION_SUBSCRIBE));
            result.setMessage(getMessage("subscription.confirm.subscribe"));
            // subscription not exists
        } else {
            dao.create(b);
            result.setSuccess(mail.sendConfirmMail(b, ACTION_SUBSCRIBE));
            result.setMessage(getMessage("subscription.confirm.subscribe"));
        }

        return result;

    }

    public SResult confirm(String action, String email, String rnd) {
        SBean bean = dao.getByEmail(email.toLowerCase());
        if (bean == null)
            return new SResult(getMessage("subscription." + action + ".failure"), getMessage("subscription.email.not.exists"), false);
        if (!bean.getHash().equals(rnd))
            return new SResult(getMessage("subscription." + action + ".failure"), getMessage("subscription.link.expired"), false);

        bean.setActive(true);
        bean.setHash(SubscriptionUtil.getHash(String.valueOf(System.currentTimeMillis())));
        dao.update(bean);
        return new SResult(getMessage("subscription." + action + ".success"), null, true);

    }


    public SResult edit(SBean b) {
        SBean bean = dao.getByEmail(b.getEmail());
        bean.setHash(SubscriptionUtil.getHash(String.valueOf(System.currentTimeMillis())));
        bean.setCategories(b.getCategories());
        bean.setType(b.getType());
        bean.setActive(true);
        dao.update(bean);
        return new SResult(getMessage("subscription.update.success"), null, true);

    }

    public SResult delete(SBean b) {
        SBean bean = dao.getByEmail(b.getEmail());
        dao.delete(bean);
        return new SResult(getMessage("subscription.unsubscribe.success"), null, true);

    }

    private String getMessage(String key, Object[] params) {
        return messages.getMessage(key, params, new Locale("RU"));
    }

    private String getMessage(String key) {
        return messages.getMessage(key, null, new Locale("RU"));
    }

}
