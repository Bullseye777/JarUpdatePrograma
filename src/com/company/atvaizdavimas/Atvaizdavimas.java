package com.company.atvaizdavimas;

import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;

/**
 * Created by A on 2017.03.14.
 */
public class Atvaizdavimas {
    private Connection connection;
    Scanner sc = new Scanner(System.in);

    public Atvaizdavimas() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kcs",
                    "root",
                    ""
            );
            //Statement statementnt = connection.createStatement();
        } catch (Exception klaida) {
            System.out.println(klaida);

        }
    }

    public void Pasisveikinimas() {
        System.out.println("Sveiki, pasirinkite ka norite padaryti 'Students' lenteleje");
    }

    public void Paklausimas() {
        System.out.println("Norint ivesti duomenis pasirinkti '1', norint trinti, pasirinkti '2'");
    }

    public void Pasirinkimas() {
        int pasirinkimas = sc.nextInt();
        switch (pasirinkimas) {

            case 1:
                Insertas();
                break;
            case 2:
                Deletinimas();
                break;
        }

    }

    public void Insertas() {


        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO `students` (`name`, `surname`, `phone`, `email`) VALUES (?, ?, ?, ?)");
            System.out.println("Ivesti Varda");
            String name = sc.next();
            System.out.println("Ivesti Pavarde");
            String surname = sc.next();
            System.out.println("Ivesti Telefona");
            String phone = sc.next();
            System.out.println("Ivesti El.pasta");
            String email = sc.next();
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, phone);
            statement.setString(4, email);

            statement.executeUpdate();


        } catch (Exception klaida) {
            System.out.println(klaida);
        }

    }

    private void Deletinimas() {
        try {
            System.out.println("Ivesti ID studento kuri norite istrinti");
            int id = sc.nextInt();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM `students` WHERE `students`.`id` = " + id + ";");
            statement.executeUpdate();

        } catch (Exception klaida) {
            System.out.println(klaida);
        }

    }


}
