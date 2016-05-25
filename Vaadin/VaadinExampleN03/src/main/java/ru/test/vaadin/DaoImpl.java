package ru.test.vaadin;

import java.util.*;

/**
 * @author Artem Pronchakov artem.pronchakov@trs-it.ru
 */
public class DaoImpl {

    private static List<Person> persons = new ArrayList<Person>();

    private static Date generateDate() {
        Random random = new Random();

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, random.nextInt(2000)+1);
        calendar.set(Calendar.MONTH, random.nextInt(11)+1);
        calendar.set(Calendar.DAY_OF_MONTH, random.nextInt(26)+1);
        return calendar.getTime();
    }

    static {
        persons.add(new Person(1L, "Person 1", generateDate()));
        persons.add(new Person(2L, "Person 2", generateDate()));
        persons.add(new Person(3L, "Person 3", generateDate()));
        persons.add(new Person(4L, "Person 4", generateDate()));
        persons.add(new Person(5L, "Person 5", generateDate()));
        persons.add(new Person(6L, "Person 6", generateDate()));
        persons.add(new Person(7L, "Person 7", generateDate()));
        persons.add(new Person(8L, "Person 8", generateDate()));
        persons.add(new Person(9L, "Person 9", generateDate()));
        persons.add(new Person(10L, "Person 10", generateDate()));
        persons.add(new Person(11L, "Person 11", generateDate()));
        persons.add(new Person(12L, "Person 12", generateDate()));
    }

    public static List<Person> getAllPersons() {
        return persons;
    }

}
