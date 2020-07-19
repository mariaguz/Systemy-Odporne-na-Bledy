package com.company.algorithms;

public class AlgsA implements IAlgs{

    @Override
    public double Fibonacci(int value) {
        double x1 = 1;
        double x2 = 1;
        double temp;

        if(value == 1) return 1;
        if(value == 2) return 1;
        for (int i = 3; i <= value; ++i) {
            temp = x1 + x2;
            x1 = x2;
            x2 = temp;
        }

        return x2;
    }

    @Override
    public double Factorial(int value) {
        double ret = 1;

        for (int i = 1; i <= value; ++i) {
            ret *= i;
        }

        return ret;
    }
}
