package com.company.algorithms;

public class AlgsC implements IAlgs{
    @Override
    public double Fibonacci(int value) {
        int first = 0;
        int var = 1, next;
        for (int i = 2; i <= value; i++) {
            next = first + var;
            first = var;
            var = next;
        }
        return var;
    }

    @Override
    public double Factorial(int value) {
        long var = 1;

        if(value == 0){
            return var;
        }

        for(int i=value; i>1; i--){
            var = var * i;
        }

        return var;
    }
}
