package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Самые частые байты

Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.

Требования:
Программа должна считывать имя файла с консоли.
Для чтения из файла используй поток FileInputStream.
В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
Данные в консоль должны выводится в одну строку.
Поток чтения из файла должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName=new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream inputStream=new FileInputStream(fileName);
        List<Integer> integers=new ArrayList<>();
        while (inputStream.available()>0){
            integers.add(inputStream.read());
        }
        inputStream.close();
        Set<Integer> maxFreqBytes=new HashSet<>();
        int maxFreq=0;
        for (Integer i:integers) {
            int currentFreq= Collections.frequency(integers, i);
            if (currentFreq>maxFreq){
                maxFreqBytes.clear();
                maxFreqBytes.add(i);
                maxFreq=currentFreq;
            }
            if (currentFreq==maxFreq){
                maxFreqBytes.add(i);
            }
        }
        for (Integer i:maxFreqBytes) {
            System.out.print(i+" ");
        }

    }
}
