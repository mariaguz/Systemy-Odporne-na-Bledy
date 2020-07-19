package com.company;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println(OnpCalc.infixToOnp("2+2*3.3"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
