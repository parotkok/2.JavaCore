package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Сортировка байт
Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.

Пример байт входного файла:
44 83 44

Пример вывода:
44 83

Требования:
Программа должна считывать имя файла с консоли.
Для чтения из файла используй поток FileInputStream.
В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
Данные в консоль должны выводится в одну строку.
Поток чтения из файла должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName=new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream inputStream=new FileInputStream(fileName);
       // List<Integer> integers=new ArrayList<>();
        // Set<Integer> integ=new HashSet<>();
        Set<Integer> set=new TreeSet<>();
        while (inputStream.available()>0){
            //integ.add(inputStream.read());
            set.add(inputStream.read());
        }
        inputStream.close();

        //integers.addAll(integ);
        //Collections.sort(integers);


        /* for (int i=0; i<integers.size(); i++) {
            System.out.print(integers.get(i)+" ");
        } */

        for (Integer i:set) {
            System.out.print(i+" ");
        }

    }
}
