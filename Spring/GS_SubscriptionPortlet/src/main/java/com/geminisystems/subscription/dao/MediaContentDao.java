package com.geminisystems.subscription.dao;

import com.geminisystems.subscription.domain.SMediaContent;

import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 27.08.2012
 * Time: 18:20:36
 * To change this template use File | Settings | File Templates.
 */
public interface MediaContentDao {
    List<SMediaContent> getAll();
    void deleteAll();
    void deleteAll(Collection entries);

}
