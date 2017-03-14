package com.company.atvaizdavimas;

import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;

/**
 * Created by A on 2017.03.14.
 */
public class Atvaizdavimas {
    private  Connection connection;


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
    public void Pasisveikinimas(){

    }


}
