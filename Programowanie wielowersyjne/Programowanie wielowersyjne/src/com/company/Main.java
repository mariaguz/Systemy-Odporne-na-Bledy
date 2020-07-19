package com.company;

import com.company.algorithms.AlgsA;
import com.company.algorithms.AlgsB;
import com.company.algorithms.AlgsC;
import com.company.test.Test;
import com.company.vote.Vote;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Vote vote = new Vote();
        //najwiekszy wyraz fib dla doubla to 1476, potem jest infinity


        /*================ZAKRES FIBONACCI===================*/
        for(int i = 1; i<=1476; ++i){
            try {
                Vote.Fibonacci(i);
            } catch (Exception e) {
                //e.printStackTrace(); //nie wypisujemy dla czytelnosci
            }
        }
        System.out.println("\n##########-------FIBONACCI<1;1476>-------##########");
        Test.print();

        //wartości graniczne
        System.out.println("-------Wartości graniczne-------");
        List<Integer> values = new ArrayList<>();
        values.add(1);values.add(2);values.add(1473);values.add(1474);values.add(1475);values.add(1476);values.add(1477);values.add(1478);
        for(Integer i : values){
            System.out.println("i -> " +i + " |      :" + (new AlgsA()).Fibonacci(i) + " | " +  (new AlgsB()).Fibonacci(i) + " | " + (new AlgsC()).Fibonacci(i));
        }

        //kilka różnic
        System.out.println("-------Różnice-------");
        values.clear();
        /*bBad*/values.add(1);
//        /*allGood*/values.add(2);values.add(3);values.add(4);values.add(15);values.add(31);values.add(44);values.add(45);values.add(46);
        /*cBad*/values.add(47);values.add(48);values.add(49);values.add(1477);values.add(1478);
        for(Integer i : values){
            System.out.println("i -> " +i + " |      :" + (new AlgsA()).Fibonacci(i) + " | " +  (new AlgsB()).Fibonacci(i) + " | " + (new AlgsC()).Fibonacci(i));
        }
        Test.clear();

        /*================UJEMNE FIBONACCI===================*/
        System.out.println("\n##########-------FIBONACCI <-10;0>-------##########");

        for(int i = -10; i<=0; ++i){
            System.out.println("i -> " +i + " |      :" + (new AlgsA()).Fibonacci(i) + " | " +  (new AlgsB()).Fibonacci(i) + " | " + (new AlgsC()).Fibonacci(i));
            try {
                Vote.Fibonacci(i);
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }


        Test.print();
        Test.clear();


        /*================ZAKRES FACTORIAL===================*/
        //najwiekszy wyraz fac dla doubla to 170, potem jest infinity
        for(int i = 1; i<=170; ++i){
            try {
                Vote.Factorial(i);
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }

        System.out.println("\n##########-------FACTORIAL<1;170>-------##########");
        Test.print();
        Test.clear();

        //wartości graniczne
        System.out.println("-------Wartości graniczne-------");
        values.clear();
        values.add(1);values.add(2);values.add(165);values.add(169);values.add(170);values.add(171);values.add(172);
        for(Integer i : values){
            System.out.println("i -> " +i + " |      :" + (new AlgsA()).Factorial(i) + " | " +  (new AlgsB()).Factorial(i) + " | " + (new AlgsC()).Factorial(i));
        }

        //kilka różnic
        System.out.println("-------Różnice-------");
        values.clear();
//        /*allGood*/values.add(1);values.add(12);
        /*bBad*/values.add(13);values.add(20);
        /*allDifferent*/values.add(21);values.add(22);values.add(23);values.add(64);values.add(65);
        /*aBad*/values.add(66);values.add(70);


        for(Integer i : values){
            System.out.println("i -> " +i + " |      :" + (new AlgsA()).Factorial(i) + " | " +  (new AlgsB()).Factorial(i) + " | " + (new AlgsC()).Factorial(i));
        }
//        Test.clear();



        /*================UJEMNE FACTORIAL===================*/

        System.out.println("\n##########-------FACTORIAL<-10;0>-------##########");


        for(int i =-10; i<=0; ++i){
            System.out.println("i -> " +i + " |      :" + (new AlgsA()).Factorial(i) + " | " +  (new AlgsB()).Factorial(i) + " | " + (new AlgsC()).Factorial(i));
            try {
                Vote.Factorial(i);
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }

        Test.print();
    }
}
