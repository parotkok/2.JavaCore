package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Минимальный байт
Ввести с консоли имя файла.
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.

Требования:
Программа должна считывать имя файла с консоли.
Для чтения из файла используй поток FileInputStream.
В консоль должен выводиться минимальный байт, считанный из файла.
Поток чтения из файла должен быть закрыт.
*/


public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName=new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream inputStream=new FileInputStream(fileName);
        int minByte=0;
        if (inputStream.available()>0){
            minByte=inputStream.read();
        }
        while (inputStream.available()>0){
            int currentByte=inputStream.read();
            if (minByte>currentByte){
                minByte=currentByte;
            }
        }
        inputStream.close();
        System.out.println(minByte);
    }
}
