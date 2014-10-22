package com.geminisystems.subscription.service;

import com.geminisystems.subscription.dao.CategoryDao;
import com.geminisystems.subscription.domain.SCategory;
import com.geminisystems.subscription.domain.SPath;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 16.11.2011
 * Time: 15:18:57
 * To change this template use File | Settings | File Templates.
 */
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public List<SCategory> getAll() {
        return categoryDao.getAll();
    }


    public SCategory create(SCategory category) {
        return categoryDao.create(category);
    }

    public void update(SCategory category) {
        categoryDao.update(category);
    }

    public void delete(SCategory category) {
        categoryDao.delete(category);
    }

    public SCategory getById(Integer id) {
        return categoryDao.getById(id);
    }

    public SPath createPath(SPath path) {
        return categoryDao.createPath(path);
    }
}
