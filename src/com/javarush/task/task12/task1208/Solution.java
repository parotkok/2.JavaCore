package com.javarush.task.task12.task1208;
/*
Свобода печати
*/
/*
Написать пять методов print с разными параметрами.

Требования:
Программа не должна выводить текст на экран.
Класс Solution должен содержать шесть методов.
Класс Solution должен содержать статический метод main().
Класс Solution должен содержать пять статических методов print() с разными параметрами.
 */
public class Solution {
    public static void main(String[] args) {

    }
    public static void print(int i){
        System.out.println(i);
    }
    public static void print(Integer integer){
        System.out.println(integer.toString());
    }
    public static void print(String s){
        System.out.println(s);
    }
    public static void print(short sh){
        System.out.println(sh);
    }
    public static void print(byte b){
        System.out.println(b);
    }

}
