package com.home.ex;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class StackMax {

    private static class  StackWrapper {

        /*
        * реализовать стэк, который может возвращать максимальный элемент за время О(1)
        * https://stepik.org/lesson/77929/step/9?unit=54781
        *
        * */

        ArrayDeque<Integer> stackOfIntegers = new ArrayDeque<>();
        ArrayDeque<Integer> maximumsList = new ArrayDeque<>();
        Integer maxElement = Integer.MIN_VALUE;

        public void putOnStack(Integer element) {
            stackOfIntegers.push(element);
            if (element > maxElement) {
                maxElement = element;
                maximumsList.push(element);
            } else maximumsList.push(maxElement);
        }

        public Integer pop() {
            maximumsList.pop();
            maxElement = maximumsList.peek();
            return stackOfIntegers.pop();
        }

        public Integer getMax() {
            return maxElement;
        }
    }

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int numberOfUserCommands = myScanner.nextInt();
        ArrayList<Integer> output = new ArrayList<>();

        StackWrapper myWrapper = new StackWrapper();
        for (int j = 0; j <= numberOfUserCommands; j++) {

            String[] command = myScanner.nextLine().split(" ");
            switch (command[0]) {
                case "max" : {
                    if (myWrapper.getMax() != null)
                        output.add(myWrapper.getMax());
                    break;
                } case "pop" : {
                    myWrapper.pop();
                    break;
                } case "push" : {
                    myWrapper.putOnStack(Integer.valueOf(command[1]));
                    break;
                }
            }
        }
        output.forEach(System.out::println);
    }
}