package com.javarush.task.task19.task1907;
/*
Считаем слово

Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.

Требования:
Программа должна считывать имя файла с консоли (используй BufferedReader).
BufferedReader для считывания данных с консоли должен быть закрыт.
Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
Поток чтения из файла (FileReader) должен быть закрыт.
Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String filename1=null;
        try (BufferedReader console=new BufferedReader(new InputStreamReader(System.in))){
            filename1=console.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        StringBuilder stringBuilder=new StringBuilder();
        int count=0;
        try (FileReader fileReader=new FileReader(filename1))   {
            while (fileReader.ready()){
                stringBuilder.append((char) fileReader.read());
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        String file=stringBuilder.toString();
        String[] array=file.split("\\W");
        for (String s:array) {
            if (s.equals("world")){
                count++;
            }
        }
        System.out.println(count);
    }
}
