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
            String name = sc.nextLine();
            System.out.println("Ivesti Pavarde");
            String surname = sc.nextLine();
            System.out.println("Ivesti Telefona");
            String phone = sc.nextLine();
            System.out.println("Ivesti El.pasta");
            String email = sc.nextLine();
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
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `students`;");
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id"));
                System.out.print("|");
                System.out.print(resultSet.getString("name"));
                System.out.print("|");
                System.out.print(resultSet.getString("surname"));
                System.out.print("");
                System.out.print(resultSet.getInt("phone"));
                System.out.print("");
                System.out.print(resultSet.getString("email"));
                System.out.println("");


            }
        } catch (Exception klaida) {
            System.out.println(klaida);
        }

    }


}
