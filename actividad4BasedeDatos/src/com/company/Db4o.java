package com.company;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import javax.swing.*;

public class Db4o {

    public static void storePerson(ObjectContainer db) {

        String name = JOptionPane.showInputDialog("Escribe un nombre");
        String lastname = JOptionPane.showInputDialog("Escribe un apellido");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Escribe una edad"));

        Person person = new Person(name, lastname, age);
        db.store(person);
        JOptionPane.showMessageDialog(null, "Stored " + person.getName() + " " + person.getLastName() + " " + person.getAge());
    }


    public static void retrieveAllPersonQBE(ObjectContainer db) {
        Person proto = new Person(null, 0, 0);
        ObjectSet result = db.queryByExample(proto);
        listResult(result);
    }

    public static void listResult(ObjectSet s) {
        Person p;
        System.out.println("");
        System.out.format("%-15s%-15s%-15s\n", "Name", "Last Name", "Age");
        while (s.hasNext()) {
            p = (Person) s.next();
            String name = p.getName();
            String lastName = p.getLastName();
            int age = p.getAge();
            System.out.format("%-15s%-15s%-15s\n", name, lastName, age);
        }

    }

    public static void deletePersonByName(ObjectContainer db) {

        String name = JOptionPane.showInputDialog("Escribe un nombre que desea eliminar");

        ObjectSet result = db.queryByExample(new Person(name, 0, 0));
        Person found = (Person) result.next();
        db.delete(found);
        JOptionPane.showMessageDialog(null, "Deleted " + found.getName() + " " + found.getLastName() + " " + found.getAge());
    }

}
