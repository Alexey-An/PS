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

    private Function<Integer, Integer> function;
    private int initiatingValue;

    public Generator(Function<Integer, Integer> function, int initiatingValue) {
        this.function = function;
        this.initiatingValue = initiatingValue;
    }

    public Integer nextValue(){
        int tempValue = initiatingValue;
        initiatingValue++;
        return function.apply(tempValue);
    }


}

class Main {
    public static void main(String[] args) {

        Generator myGen = new Generator(FunctionSet::getProgressionSum, 2);
        System.out.println(myGen.nextValue());
        System.out.println(myGen.nextValue());
        System.out.println(myGen.nextValue());

        System.out.println();

        Generator gen2 = new Generator(x -> x++, 5);
        System.out.println(gen2.nextValue());
        System.out.println(gen2.nextValue());
        System.out.println(gen2.nextValue());
        System.out.println(gen2.nextValue());
        System.out.println(gen2.nextValue());

//



    }
}