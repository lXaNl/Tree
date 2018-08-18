package controller;

import dao.PersonDAOImpl;
import db.MockDB;
import model.Person;
import service.UserService;
import service.UserServiceIml;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Класс для взаимодействия с пользователем.
 * Если функционал будет разрастаться, можно перенести его в отдельные котроллеры разделив по функционалу.
 */
public class BaseController {

    private UserService service;
    private int menuCase;
    private int editMenuCase;
    private static int idForEdit;

    /**
     *  Не инициализируем интерфейс UserService явно, даём возможность сделать это вызывающим классам.
     *  Таким образом добиваемся ещё более слабой связанности.
     */
    public BaseController(UserService service) {
        this.service = service;
    }

    public void sample(){

    }

    public void setPersonIdForEdit(){
        System.out.println("Enter Person's ID for edit");
        Scanner sc = new Scanner(System.in);
        idForEdit = sc.nextInt();
    }

    public static int getPersonIdForEdit(){
        return idForEdit;
    }

    void menuSwither(){
        Scanner sc  = new Scanner(System.in);
        System.out.println("\n**********************************************************************************************************");
        System.out.println("* 1 - Select Person \t2 - Add person \t3 - Full list \t4 - Delete person " +
                "\t5 - Edit person \t0 - Exit *");
        System.out.println("**********************************************************************************************************");
        menuCase = sc.nextInt();
    }
    void editingMenuSwitcher(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n**********************************************************************************************");
        System.out.println("* 1 - add Mother \t2 - add Father \t3 - add Son \t4 - add Daughter \t0 - Back to main menu *");
        System.out.println("**********************************************************************************************");
        editMenuCase = sc.nextInt();
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        boolean menu = true;
        boolean editingMenu = true;
        System.out.println("1 - Select Person \n3 - Full list \n0 - Exit");
        menuCase = sc.nextInt();
        do {
            switch (menuCase) {
                case 0 :
                    menu = false;
                    break;

                case 1 :
                    service.getPerson();
                    menuSwither();
                    break;

                case 2 :
                    service.addPerson();
                    menuSwither();
                    break;

                case 3 :
                    service.getFullList();
                    menuSwither();
                    break;

                case 4 :
                    service.deletePerson();
                    menuSwither();
                    break;

                case 5 :
                    setPersonIdForEdit();
                    editingMenuSwitcher();
                    do {
                        switch (editMenuCase){
                            case 1 :
                                service.addMother();
                                editingMenuSwitcher();
                                break;

                            case 2 :
                                service.addFather();
                                editingMenuSwitcher();
                                break;

                            case 3 :
                                service.addSon();
                                editingMenuSwitcher();
                                break;

                            case 4 :
                                service.addDaughter();
                                editingMenuSwitcher();
                                break;
                            case 0 :
                                editingMenu = false;
                                menuSwither();
                                break;
                        }
                    }
                    while (editingMenu);

                case 6:

                    break;
            }
        }
        while (menu);
    }

    /**
     * Точка входа. Здесь и инициализируем наши сервисы, ДАО и тд.
     * @param args
     */
    public static void main(String[] args) {
        BaseController baseController = new BaseController(new UserServiceIml(new PersonDAOImpl()));
        baseController.menu();
    }
}
