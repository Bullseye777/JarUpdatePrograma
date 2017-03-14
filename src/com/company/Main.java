package com.company;

import com.company.atvaizdavimas.Atvaizdavimas;

public class Main {

    public static void main(String[] args) {

        Atvaizdavimas objektas = new Atvaizdavimas();
        objektas.Pasisveikinimas();
        while (true) {
            objektas.Paklausimas();
            objektas.Pasirinkimas();
        }
    }
}
