package com.home.ex;

import java.util.function.Function;

class FunctionSet {

    public static Integer getProgressionSum(Integer n) {
        /* Вычисляет сумму от одного до n
         **/
        if (n == 1) return 1;
        else return n + getProgressionSum(n - 1);
    }

    public static Integer getFactorial(Integer n) {
        /* Вычисляет факториал n
         **/
        if (n == 1)  return 1;
        else return n * getFactorial(n - 1);
    }

}


public class Generator <T>{

    private Function<T, T> function;
    private volatile T initValue;

    public Generator(Function<T, T> function, T initValue) {
        this.function = function;
        this.initValue = initValue;
    }

    public synchronized T nextValue(){
        initValue = function.apply(initValue);
        return initValue;
    }
}


class Main {

    public static void main(String[] args) {

        Generator gen2 = new Generator<Integer>(x -> ++x, 5);

        Runnable thread1 = () -> {
            for (int i = 0; i < 120; i++) {
                String el = "# " + (gen2.nextValue());
                System.out.println(el);
            }
        };

        Runnable thread2 = () -> {
            for (int i = 0; i < 120; i++) {
                String el = "* " + gen2.nextValue();
                System.out.println(el);
            }
        };

        new Thread(thread2).start();
        new Thread(thread1).start();
    }
}