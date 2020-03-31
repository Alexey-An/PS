package com.home.ex;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        /*
         * удалить из коллекции элементы, находящиеся на четных позициях и
         * вывести результат в обратном порядке
         * https://stepik.org/lesson/12776/step/15?unit=3124
         *
         * */

        Scanner myScanner = new Scanner(System.in);
        List<Integer> nums = new LinkedList<>();

        while (myScanner.hasNextInt()) {
            nums.add(myScanner.nextInt());
        }

        int i = 0;
        Iterator<Integer> iter = nums.iterator();

        while (iter.hasNext()) {
            iter.next();
            if (i % 2 == 0) {
                iter.remove();
            }
            i++;
        }

        Collections.reverse(nums);
        nums.forEach(element -> System.out.print(element + " "));
    }

}