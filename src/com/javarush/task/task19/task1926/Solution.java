package com.javarush.task.task19.task1926;

import java.io.*;
import java.util.Map;

/*
Перевертыши

1. Считать с консоли имя файла. Считать содержимое файла.
2. Для каждой строки в файле:
2.1. переставить все символы в обратном порядке.
2.2. вывести на экран.
3. Закрыть потоки.

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА

Требования:
Программа должна считывать имя файла с консоли (используй BufferedReader).
BufferedReader для считывания данных с консоли должен быть закрыт.
Программа должна считывать содержимое файла (используй FileReader).
Поток чтения из файла (FileReader) должен быть закрыт.
Программа должна выводить в консоль все символы из файла в обратном порядке.
*/
public class Solution {
    public static void main(String[] args) {
        String fileName=null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName=reader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        try (BufferedReader bfr = new BufferedReader(new FileReader(fileName))){
            while (bfr.ready()){
                String line = bfr.readLine();
                StringBuffer a = new StringBuffer(line);
                System.out.println(a.reverse());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
