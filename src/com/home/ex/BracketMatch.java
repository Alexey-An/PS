package com.home.ex;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BracketMatch {

    public static void main(String[] args) {

        /*
         * на вход программа принимает строку скобок вида { или [ или (
         * если каждой открывающей скобке соответсвует подходящая закрывающая скобка,
         * то программа вернет true, в противном случае вернет false
         * https://stepik.org/lesson/77929/step/6?unit=54781
         * */

        ArrayDeque<Character> bracketDeque = new ArrayDeque<>();
        Scanner myScanner = new Scanner(System.in);
        boolean matchingBrackets = true;

        CharacterIterator iter = new StringCharacterIterator(myScanner.next());
        for (char c = iter.first(); c != iter.DONE; c = iter.next()) {
            if (c == '(' | c =='[' | c =='{') bracketDeque.push(c);
            else if (c ==')' | c == ']' | c == '}') {
                try {
                    char openingBracket = bracketDeque.pop();
                    switch (openingBracket) {
                        case '(':
                            if (c != ')') matchingBrackets = false;
                            break;
                        case '[':
                            if (c != ']') matchingBrackets = false;
                            break;
                        case '{':
                            if (c != '}') matchingBrackets = false;
                            break;
                    }
                } catch (NoSuchElementException e) {
                    matchingBrackets = false;
                    break;
                }
            }
        }
        if (!bracketDeque.isEmpty()) matchingBrackets = false;
        System.out.println(matchingBrackets);
    }
}
