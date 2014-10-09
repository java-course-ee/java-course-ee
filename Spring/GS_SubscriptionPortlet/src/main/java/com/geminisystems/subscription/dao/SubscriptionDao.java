package com.geminisystems.subscription.dao;

import com.geminisystems.subscription.domain.SBean;
import com.geminisystems.subscription.domain.SType;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 08.11.2011
 * Time: 14:31:31
 * To change this template use File | Settings | File Templates.
 */
public interface SubscriptionDao {

    public SBean getByEmail(String email);
    public SBean create(SBean bean);
    public SBean update(SBean bean);
    public void delete(SBean bean);
    public List<SBean> getAll();
    public List<SBean> getAllActive(SType type);



}
