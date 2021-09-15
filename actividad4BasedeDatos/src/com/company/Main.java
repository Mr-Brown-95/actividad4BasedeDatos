package com.company;

import com.db4o.ObjectContainer;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Db4o db4o = new Db4o();

        String DB4OFILENAME = "ejemplo.db4o";

        ObjectContainer db = com.db4o.Db4o.openFile(DB4OFILENAME);

        Scanner input = new Scanner(System.in);

        int op = 0;

        try {
            do {
                op = Integer.parseInt(JOptionPane.showInputDialog("1.-Agregar\n" +
                        "2.-Mostrar\n" +
                        "3.-Elminar\n" +
                        "4.-Salir"));

                switch (op) {
                    case 1:
                        db4o.storePerson(db);
                        break;
                    case 2:
                        db4o.retrieveAllPersonQBE(db);
                        break;
                    case 3:
                        db4o.deletePersonByName(db);
                        break;
                    case 4:
                        break;
                    default:

                }

            } while (op != 4);

        } finally {

            db.close();
        }

    }

}
