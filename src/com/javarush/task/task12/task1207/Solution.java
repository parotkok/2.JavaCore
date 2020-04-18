package com.javarush.task.task12.task1207;
/*
Int и Integer
*/
/*
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.

Требования:
Класс Solution должен содержать статический метод main().
Класс Solution должен содержать статический void метод print() с параметром типа int.
Класс Solution должен содержать статический void метод print() с параметром типа Integer.
Метод main() должен вызывать метод print() с параметром типа int.
Метод main() должен вызывать метод print() с параметром типа Integer.
 */
public class Solution {
    public static void main(String[] args) {
        print(10);
        print(new Integer(15));
    }

    public static void print(int n){
        System.out.println(n);

    }
    public static void print(Integer i){
        System.out.println(i.toString());
    }
}
