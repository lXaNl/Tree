package dao;

import model.Person;

public interface PersonDAO {
    /**
     * Метод возвращающий человека по его id.
     */
    Person getPersonById(int id);
    void addPerson();
    void getFullList();
    void getPerson();
    void deletePerson();

    void addMother();
    void addFather();
    void addSon();
    void addDaughter();

}