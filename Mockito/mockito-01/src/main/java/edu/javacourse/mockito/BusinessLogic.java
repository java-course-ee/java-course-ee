package edu.javacourse.mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Pronchakov artem.pronchakov@ocrv.ru
 */
public class BusinessLogic {

    private DAO dao;

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    public List<String> getAllBooksNames() {
        List<String> result = new ArrayList<>();
        dao.getAllBooks().forEach(b -> result.add(b.getName()));
        return result;
    }
}
