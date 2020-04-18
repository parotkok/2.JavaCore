package com.javarush.task.task12.task1206;
/*
Выполняем перегрузку!
*/
/*
Написать два метода: print(int) и print(String).

Требования:
Программа не должна выводить текст на экран.
Класс Solution должен содержать три метода.
Класс Solution должен содержать статический метод main().
Класс Solution должен содержать статический метод print() с параметром типа int.
Класс Solution должен содержать статический метод print() с параметром типа String.
 */
public class Solution {
    public static void main(String[] args) {
    }

    public static void print(int i) {
        System.out.println(i);
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
