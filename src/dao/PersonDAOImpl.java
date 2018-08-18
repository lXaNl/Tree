package dao;

import controller.BaseController;
import db.MockDB;
import model.Person;
import service.UserService;
import service.UserServiceIml;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Реализация DAO - Data Access Object.
 * Обеспечивает работу с базой данных.
 * В нашем случае с иммитацией базы - классом MockDB.
 * Класс должен отвечать за доступ к данным, и не нести в себе бизнес логики.
 * Для работы с разными сущностями(моделями), должны быть разные DAO.
 */
public class PersonDAOImpl implements PersonDAO {

    @Override
    public Person getPersonById(int id) {
        for (Person person : MockDB.persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public void addPerson(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name ");
        String name = sc.next();
        System.out.println("Enter Date Sample - \"yyyy-mm-dd\" ");
        String stringLocalDate = sc.next();
        LocalDate localDate = LocalDate.parse(stringLocalDate);
        MockDB.persons.add(new Person(name,localDate));
    }

    @Override
    public void getFullList(){
        System.out.println(MockDB.persons.toString());
    }

    @Override
    public void getPerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id человека: ");
        int id = scanner.nextInt();
        Person person = getPersonById(id);
        System.out.println(person);
    }

    @Override
    public void deletePerson(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID ");
        int idForDelete = sc.nextInt();
        for (Person person :MockDB.persons) {
            if (person.getId()==idForDelete){
                MockDB.persons.remove(person);
                break;
            }
        }
    }

    @Override
    public void addMother() {
        BaseController baseController = new BaseController(new UserServiceIml(new PersonDAOImpl()));
        UserServiceIml service = new UserServiceIml(new PersonDAOImpl());
        service.addPerson();
        getPersonById(BaseController.getPersonIdForEdit()).setMotherId(service.getPersonById(Person.getNextID()));
    }

    @Override
    public void addFather() {
        BaseController baseController = new BaseController(new UserServiceIml(new PersonDAOImpl()));
        UserServiceIml service = new UserServiceIml(new PersonDAOImpl());
        service.addPerson();
        getPersonById(BaseController.getPersonIdForEdit()).setFatherId(service.getPersonById(Person.getNextID()));
    }

    @Override
    public void addSon() {
        BaseController baseController = new BaseController(new UserServiceIml(new PersonDAOImpl()));
        UserServiceIml service = new UserServiceIml(new PersonDAOImpl());
        service.addPerson();
        getPersonById(BaseController.getPersonIdForEdit()).setSonId(service.getPersonById(Person.getNextID()));
    }

    @Override
    public void addDaughter() {
        BaseController baseController = new BaseController(new UserServiceIml(new PersonDAOImpl()));
        UserServiceIml service = new UserServiceIml(new PersonDAOImpl());
        service.addPerson();
        getPersonById(BaseController.getPersonIdForEdit()).setDaughterId(service.getPersonById(Person.getNextID()));
    }

}