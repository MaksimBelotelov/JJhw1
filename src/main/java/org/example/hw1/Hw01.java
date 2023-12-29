package org.example.hw1;
/*
   Напишите программу, которая использует Stream API для обработки списка чисел.
   Программа должна вывести на экран среднее значение всех четных чисел в списке.
*/

import java.util.Arrays;
import java.util.List;

public class Hw01 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 3, 3, 3, 4, 4, 4, 6, 5);

        double avr = list.stream()
                .filter(n -> n % 2 == 0)
                .mapToDouble(n -> n)
                .average()
                .orElse(0);

        System.out.println(avr);
    }
}
