package com.home.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {

    public static void main(String[] args) throws IOException {

        String testStringOfText = "This 012 is const; Text-String, is SupPosed: to be parsed-parsed!";

//        //[^\\p{L}\\p{Digit}_]+
//        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
//        in.close();

        String line = testStringOfText;

        TreeMap<String, Long> wordsMap = new TreeMap(Stream.of(line.trim().toLowerCase()
                .split("!\\s*|,\\s*|-|\\s|;\\s*|:\\s*|\\.\\s*|\\?\\s*"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        wordsMap.forEach((x, y) -> System.out.println(x + " " + y));

    }

}
