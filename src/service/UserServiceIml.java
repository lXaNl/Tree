package service;

import dao.PersonDAO;
import db.MockDB;
import model.Person;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Реализация сервиса. Класс предназначенный для работы с бизнес логикой.
 * Для работы с разными сущностями(моделями), должны быть разные сервисы.
 */
public class UserServiceIml implements UserService {

    private PersonDAO dao;

    /**
     * Не инициализируем интерфейс PersonDAO явно, даём возможность сделать это вызывающим классам.
     * Таким образом добиваемся ещё более слабой связанности.
     */
    public UserServiceIml(PersonDAO dao) {
        this.dao = dao;
    }

    @Override
    public Person getPersonById(int id) {
        return dao.getPersonById(id);
    }

    @Override
    public void addPerson(){
        dao.addPerson();
    }

    @Override
    public void getFullList(){
        dao.getFullList();
    }

    @Override
    public void getPerson(){
        dao.getPerson();
    }

    @Override
    public void deletePerson(){
        dao.deletePerson();
    }

    @Override
    public void addMother() {
        dao.addMother();
    }

    @Override
    public void addFather() {
        dao.addFather();
    }

    @Override
    public void addSon() {
        dao.addSon();
    }

    @Override
    public void addDaughter() {
        dao.addDaughter();
    }


}
