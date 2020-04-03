package com.home.ex;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Stack {

    public static void main(String[] args) {

        /*
        * двунаправленная очередь хранит элементы Integer. нужно добавлять
        * четные номера в начало двунаправленной очереди, а
        * нечетные номера в конце.
        * https://stepik.org/lesson/77929/step/6?unit=54781
        * */

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Scanner myScanner = new Scanner(System.in);
        int stackHeight = myScanner.nextInt();
        for (int i=0; i<stackHeight; i++){
            Integer element = myScanner.nextInt();
            if (element % 2 == 0) deque.offerFirst(element);
            else deque.offerLast(element);
        }
         while (!deque.isEmpty()){
            System.out.println(deque.pop());
        }
    }

}
