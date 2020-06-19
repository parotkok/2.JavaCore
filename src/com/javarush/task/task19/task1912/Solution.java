package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*
Ридер обертка 2

В методе main подмените объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна заменять все подстроки "te" на "??".
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.
Выведи модифицированную строку в консоль.

Требования:
Класс Solution должен содержать класс TestString.
Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
Класс TestString должен содержать публичный void метод printSomething().
Метод printSomething() класса TestString должен выводить на экран строку "it's a text for testing".
Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream c параметром конструктора ByteArrayOutputStream).
Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль объекта System.out
Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
Метод main(String[] args) класса Solution должен модифицировать строку выведенную методом printSomething() согласно заданию, и выводить её в консоль.
*/
public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);

        testString.printSomething(); //now the value is stored in array

        System.setOut(consoleStream);

        String result=outputStream.toString().replaceAll("te", "??");

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
