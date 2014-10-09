package com.geminisystems.subscription.dao;

import com.geminisystems.subscription.domain.SCategory;
import com.geminisystems.subscription.domain.SPath;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 16.11.2011
 * Time: 14:19:36
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryDao {

    public SCategory create(SCategory category);
    public void update(SCategory category);
    public List<SCategory> getAll();
    public void delete(SCategory category);
    public SCategory getById(Integer id);
    public SPath createPath(SPath path);

}
