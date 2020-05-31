package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.

Требования:
Программа должна считывать имя файла с консоли.
Для чтения из файла используй поток FileInputStream.
В консоль должен выводиться максимальный байт, считанный из файла.
Поток чтения из файла должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName=new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream inputStream=new FileInputStream(fileName);
        int maxByte=0;
        if (inputStream.available()>0){
            maxByte=inputStream.read();
        }
        while (inputStream.available()>0){
            int currentByte=inputStream.read();
            if (maxByte<currentByte){
                maxByte=currentByte;
            }
        }
        inputStream.close();
        System.out.println(maxByte);
    }
}
