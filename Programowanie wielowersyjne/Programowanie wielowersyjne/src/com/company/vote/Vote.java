package com.company.vote;

import com.company.algorithms.AlgsA;
import com.company.algorithms.AlgsB;
import com.company.algorithms.AlgsC;
import com.company.algorithms.IAlgs;
import com.company.test.Test;

public class Vote {

    public static double Fibonacci(int value) throws Exception{

        IAlgs algsA = new AlgsA();
        IAlgs algsB = new AlgsB();
        IAlgs algsC = new AlgsC();

        double fib1, fib2, fib3;

        fib1 = algsA.Fibonacci(value);
        fib2 = algsB.Fibonacci(value);
        fib3 = algsC.Fibonacci(value);

        if(fib1 == fib2 && fib1 == fib3){
            //wszystkie zgodne - najlepszy przypadek;
            Test.incrementAllGood(value);
            return fib1;
        }
        if(fib1 == fib2 && fib1 != fib3){
            //2 zgodne - sredni przypadek
            Test.incrementCBad(value);
            return fib1;
        }
        if(fib1 == fib3 && fib1 != fib2){
            //2 zgodne - sredni przypadek
            Test.incrementBBad(value);
            return fib1;
        }
        if(fib2 == fib3 && fib2 != fib1){
            //2 zgodne - sredni przypadek
            Test.incrementABad(value);
            return fib2;
        }

        Test.incrementAllDifferent(value);
        throw new Exception("All return values are different.");
    }

    public static double Factorial(int value) throws Exception{

        IAlgs algsA = new AlgsA();
        IAlgs algsB = new AlgsB();
        IAlgs algsC = new AlgsC();

        double fac1, fac2, fac3;

        fac1 = algsA.Factorial(value);
        fac2 = algsB.Factorial(value);
        fac3 = algsC.Factorial(value);

        if(fac1 == fac2 && fac1 == fac3){
            //wszystkie zgodne - najlepszy przypadek;
            Test.incrementAllGood(value);
            return fac1;
        }
        if(fac1 == fac2 && fac1 != fac3){
            //2 zgodne - sredni przypadek
            Test.incrementCBad(value);
            return fac1;
        }
        if(fac1 == fac3 && fac1 != fac2){
            //2 zgodne - sredni przypadek
            Test.incrementBBad(value);
            return fac1;
        }
        if(fac2 == fac3 && fac2 != fac1){
            //2 zgodne - sredni przypadek
            Test.incrementABad(value);
            return fac2;
        }

        Test.incrementAllDifferent(value);
        throw new Exception("All return values are different.");
    }
}
