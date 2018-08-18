package service;

import db.MockDB;
import model.Person;

import java.time.LocalDate;
import java.util.Scanner;

public interface UserService {

    /**
     * Метод возвращающий человека по его id.
     */
    Person getPersonById(int id);

    /**
     * Метод добавляющий юзера
     */
    void addPerson();
    void getFullList();
    void getPerson();
    void deletePerson();

    void addMother();
    void addFather();
    void addSon();
    void addDaughter();

}