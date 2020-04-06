package com.home.ex;

import java.util.function.Function;

class FunctionSet {

    public static int getProgressionSum(int n) {
        /* Вычисляет сумму от одного до n
         **/
        if (n == 1) return 1;
        else return n + getProgressionSum(n - 1);
    }

    public static int getFactorial(int n) {
        /* Вычисляет факториал n
         **/
        if (n == 1)  return 1;
        else return n * getFactorial(n - 1);
    }

}


public class Generator {

    Function<Integer, Integer> function;

    public Generator(Function<Integer, Integer> function) {
        this.function = function;
    }
}

class Main {
    public static void main(String[] args) {
        Generator generator1 = new Generator(FunctionSet::getProgressionSum);
        Generator generator2 = new Generator(FunctionSet::getFactorial);
        System.out.println(generator1.function.apply(5));
        System.out.println(generator2.function.apply(5));
    }
}