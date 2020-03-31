package com.home.ex;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static <T, U> Function<T, U> ternaryOperator(

            /*
            * реализовать тернарный оператор для двух функций
            * https://stepik.org/lesson/12777/step/8?unit=3125
            *
            * */

            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return (t) -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static void main(String[] args) {
	// write your code here
    }
}
