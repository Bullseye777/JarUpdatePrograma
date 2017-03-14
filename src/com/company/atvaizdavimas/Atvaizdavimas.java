package com.company.atvaizdavimas;

import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;

/**
 * Created by A on 2017.03.14.
 */
public class Atvaizdavimas {
    private Connection connection;


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
        Scanner sc = new Scanner(System.in);
        int pasirinkimas = sc.nextInt();
        switch (pasirinkimas){

            case 1 :

                break;
            case 2 :

                break;
        }


    }


}
