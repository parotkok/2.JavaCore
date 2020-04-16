package com.javarush.task.task11.task1123;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Задача по алгоритмам
Написать метод, который возвращает минимальное и максимальное числа в массиве.

Требования:
Программа не должна считывать данные с клавиатуры.
Класс Pair не изменять.
Метод main не изменять.
Допиши реализацию метода getMinimumAndMaximum, он должен возвращать пару из минимума и максимума.
Программа должна вывести правильный результат.
Метод getMinimumAndMaximum не должен изменять массив inputArray.
 */
public class Solution {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        // напишите тут ваш код
        Arrays.sort(inputArray);
        return new Pair<>(inputArray[0],inputArray[inputArray.length-1]);
    }

    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
