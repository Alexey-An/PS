package com.home.ex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main3 {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> resultSet = new HashSet<>(set1);
        resultSet.addAll(set2);
        resultSet.removeIf((t) -> set1.contains(t) & set2.contains(t));
        return resultSet;
    }

    public static void main(String[] args) {
        HashSet<Integer> kappa = new HashSet<>();
        HashSet<Integer> gamma = new HashSet<>();
        kappa.addAll(Arrays.asList(0, 1, 2, 3));
        gamma.addAll(Arrays.asList(2, 3, 4, 5));
        symmetricDifference(kappa, gamma).forEach(System.out::println);
    }



}
