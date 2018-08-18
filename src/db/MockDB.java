package db;

import model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Заглушка нашей базы данных.
 */
public final class MockDB {

    public static final List<Person> persons = new ArrayList<>();

    static {
        persons.add(new Person("John", LocalDate.of(1991, 7, 17)));
    }

}
