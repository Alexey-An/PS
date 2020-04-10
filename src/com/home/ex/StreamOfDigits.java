package com.home.ex;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfDigits {

    public static IntStream pseudoRandomStream(int seed) {
        /*
         * напсать стрим, который генерирует последовательность псеводслучайных чисел
         * алгоритм генерации https://stepik.org/lesson/12781/step/11?unit=3128
         * */

        return IntStream.iterate(seed, n -> ((n * n) % 10000) / 10);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        /*
        * реализовать метод, который находит min и max среди элементов стрима,
        * затем передает их в качестве параметов в minMaxConsumer
        * по условию задачи стрим не бесконечен.
        * https://stepik.org/lesson/12781/step/12?unit=3128
        * */

        List<T> kList = new LinkedList<>();
        stream.sorted(order).forEach(x -> kList.add(x));
        if(kList.isEmpty()) minMaxConsumer.accept(null, null);
        else minMaxConsumer.accept(kList.get(0), kList.get(kList.size() - 1));
    }

    public static void main(String[] args){

        for (int i=13; i < 15; i++) {
            pseudoRandomStream(i).limit(15)
                    .mapToObj(x -> " " + x)
                    .forEachOrdered(System.out::print);
            System.out.println();
        }


        IntStream myStream = IntStream.rangeClosed(0, 10);
        myStream.forEach(System.out::println);

        IntStream streamOfElements = IntStream.of(3, 5, 7, 9, 4);

        List<Integer> krye = new LinkedList<>();

        streamOfElements.sorted().forEach((x) -> krye.add(x));
        krye.forEach(System.out::print);

    }
}
