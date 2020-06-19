package com.javarush.task.task19.task1915;

import java.io.*;

/*
Дублируем текст

Считай с консоли имя файла.
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить весь текст и на консоль и в файл, имя которого ты считал.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.
Закрой поток файла.

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing

Требования:
Класс Solution должен содержать класс TestString.
Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
Класс TestString должен содержать публичный void метод printSomething().
Метод printSomething() класса TestString должен выводить на экран строку "it's a text for testing".
В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream c конструктором принимающим ByteArrayOutputStream).
Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль объекта System.out.
Метод main(String[] args) класса Solution должен один раз вызвать метод printSomething() объекта testString.
Метод main(String[] args) класса Solution должен выводить и в консоль и в файл строку выведенную методом printSomething() (используй FileOutputStream).
Поток записи в файл (FileOutputStream) должен быть закрыт.
*/
public class Solution {
    public static TestString testString=new TestString();

    public static void main(String[] args) {
        String fileName=null;

        try (BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in))){
            fileName=bufferedReader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }

        PrintStream consoleStream=System.out;
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        PrintStream printStream=new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething(); //now the value is stored in array
        System.setOut(consoleStream);
        //String result=outputStream.toString();

        try (FileOutputStream fos=new FileOutputStream(fileName)){
            outputStream.writeTo(fos);
            //fos.write(result.getBytes());
            System.out.println(outputStream.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
