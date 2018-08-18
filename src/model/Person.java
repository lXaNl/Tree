package model;

import db.MockDB;
import sun.reflect.generics.tree.Tree;

import java.time.LocalDate;

public class Person {

    private int id;
    private String name;
    private LocalDate birthday;
    private Person father;
    private Person mother;
    private Person son;
    private Person daughter;
    private static int nextID;
    {
        id = nextID;
        nextID++;
    }


    static{
        nextID = 0;
    }

    public Person() {
    }

    public Person( String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setFatherId(Person father){
        this.father=father;
        MockDB.persons.add(father);
    }

    public void setMotherId(Person mother){
        this.mother = mother;
        MockDB.persons.add(mother);
    }

    public void setSonId(Person son){
        this.son = son;
        MockDB.persons.add(son);
    }
    public void setDaughterId(Person daughter){
        this.daughter = daughter;
        MockDB.persons.add(daughter);
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public Person getSon() {
        return son;
    }

    public Person getDoughter() {
        return daughter;
    }

    public static int getNextID() {
        return nextID-1;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", father=" + father +
                ", mother=" + mother +
                ", son=" + son +
                ", doughter=" + daughter +
                '}'+"\n";
    }
}
