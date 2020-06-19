package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
И еще один адаптер

Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner. Поле инициализировать в конструкторе с одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные только одного человека.

Требования:
PersonScanner должен быть интерфейсом.
Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её, и возвращать данные только одного человека, в виде объекта класса Person.
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;
        PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }
        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
        @Override
        public Person read() throws IOException {
            Person person=null;
            if (fileScanner.hasNext()){
                String[] str = fileScanner.nextLine().split(" ", 4);
                Date date=null;
                try {
                    date = new SimpleDateFormat("dd MM yyyy").parse(str[3]);
                }catch (ParseException e){
                    e.printStackTrace();
                }
                String firstName = str[1];
                String middleName = str[2];
                String lastName = str[0];
                person = new Person(firstName,middleName,lastName, date);
            }
            return person;
        }
    }
}
