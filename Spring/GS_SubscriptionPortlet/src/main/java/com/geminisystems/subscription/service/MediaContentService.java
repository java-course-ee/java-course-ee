package com.geminisystems.subscription.service;

import com.geminisystems.subscription.dao.MediaContentDao;
import com.geminisystems.subscription.domain.SMediaContent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 27.08.2012
 * Time: 18:30:11
 * To change this template use File | Settings | File Templates.
 */
public class MediaContentService {

    @Autowired
    private MediaContentDao mediaContentDao;


    public List<SMediaContent> getAll() {
        return mediaContentDao.getAll();
    }

    public void deleteAll() {
        mediaContentDao.deleteAll();
    }

    public void setMediaContentDao(MediaContentDao mediaContentDao) {
        this.mediaContentDao = mediaContentDao;
    }

    public void deleteAll(Collection entries) {
        mediaContentDao.deleteAll(entries);
    }
}
