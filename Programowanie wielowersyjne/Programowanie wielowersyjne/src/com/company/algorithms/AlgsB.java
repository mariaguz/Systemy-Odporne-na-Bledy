package com.company.algorithms;

public class AlgsB implements IAlgs{

    @Override
    public double Fibonacci(int value){
        double i = 0, first=0, second=1, sum=0;

        while(i < value-1){
            sum = first + second;
            first = second;
            second = sum;

            i++;
        }

        return sum;
    }

    @Override
    public double Factorial(int value){
        Integer score = 1, i = 1;

        while(i <= value){
            score = score * i;
            i++;
        }

        return score;
    }
}
