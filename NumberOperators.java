/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numberoperators;

/**
 *
 * @author user
 */


import java.util.ArrayList;
import java.math.BigDecimal;

public class NumberOperators {
    public static void main(String[] args) {
        // Створення списку чисел різних типів
        ArrayList<Number> numbers = new ArrayList<>();
        numbers.add((byte) 10);
        numbers.add((short) 20);
        numbers.add(30);
        numbers.add(40.7);
        numbers.add(50);
        numbers.add(60.3);
        numbers.add(70);
        numbers.add(80.1);
        numbers.add(90);
        numbers.add(100.9);
        numbers.add(new BigDecimal("70.7"));
        numbers.add(33.33f);
        numbers.add(7777L);

        // Виклик методів для виконання завдань
        printNumbers(numbers);
        printAsIntegers(numbers);
        printAsDecimals(numbers);
        splitByType(numbers);
        System.out.println("Sum: " + calculateSum(numbers));
    }

    // Метод для виведення всіх чисел
    public static void printNumbers(ArrayList<Number> numbers) {
        System.out.print("Numbers in the list: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // Метод для виведення чисел у форматі цілих чисел
    public static void printAsIntegers(ArrayList<Number> numbers) {
        System.out.print("Numbers as integers: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i).intValue());
            if (i < numbers.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // Метод для виведення чисел у форматі дробових чисел з 2 знаками після коми
    public static void printAsDecimals(ArrayList<Number> numbers) {
        System.out.print("Numbers with 2 decimal places: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%.2f", numbers.get(i).doubleValue());
            if (i < numbers.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // Метод для розподілу чисел за типом і виведення у різні списки
    public static void splitByType(ArrayList<Number> numbers) {
        ArrayList<Byte> byteNumbers = new ArrayList<>();
        ArrayList<Short> shortNumbers = new ArrayList<>();
        ArrayList<Integer> integerNumbers = new ArrayList<>();
        ArrayList<Long> longNumbers = new ArrayList<>();
        ArrayList<Float> floatNumbers = new ArrayList<>();
        ArrayList<Double> doubleNumbers = new ArrayList<>();
        ArrayList<BigDecimal> bigDecimalNumbers = new ArrayList<>();

        for (Number num : numbers) {
            if (num instanceof Byte) {
                byteNumbers.add((Byte) num);
            } else if (num instanceof Short) {
                shortNumbers.add((Short) num);
            } else if (num instanceof Integer) {
                integerNumbers.add((Integer) num);
            } else if (num instanceof Long) {
                longNumbers.add((Long) num);
            } else if (num instanceof Float) {
                floatNumbers.add((Float) num);
            } else if (num instanceof Double) {
                doubleNumbers.add((Double) num);
            } else if (num instanceof BigDecimal) {
                bigDecimalNumbers.add((BigDecimal) num);
            }
        }

        System.out.println("List of bytes: " + byteNumbers);
        System.out.println("List of shorts: " + shortNumbers);
        System.out.println("List of integers: " + integerNumbers);
        System.out.println("List of longs: " + longNumbers);
        System.out.println("List of floats: " + floatNumbers);
        System.out.println("List of doubles: " + doubleNumbers);
        System.out.println("List of BigDecimals: " + bigDecimalNumbers);
    }

    // Метод для обчислення суми всіх чисел
    public static BigDecimal calculateSum(ArrayList<Number> numbers) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Number num : numbers) {
            if (num instanceof BigDecimal) {
                sum = sum.add((BigDecimal) num);
            } else {
                sum = sum.add(BigDecimal.valueOf(num.doubleValue()));
            }
        }
        return sum;
    }
}