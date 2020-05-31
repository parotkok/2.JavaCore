package com.javarush.task.task18.task1807;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Подсчет запятых
С консоли считать имя файла.
Посчитать в файле количество символов ',', количество вывести на консоль.
Закрыть потоки.

Подсказка:
нужно сравнивать с ascii-кодом символа ','.

Требования:
Программа должна считывать имя файла с консоли.
Для чтения из файла используй поток FileInputStream.
В консоль должно выводится число запятых в считанном файле.
Поток чтения из файла должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName=new BufferedReader(new InputStreamReader(System.in)).readLine();
       // FileInputStream inputStream=new FileInputStream(fileName);
       // List<Integer> list=new ArrayList<>();
        int numberOfCommas=0;

        try (FileInputStream inputStream=new FileInputStream(fileName)){
            while (inputStream.available()>0){
                int simbol=inputStream.read();
                if (simbol==44){
                    numberOfCommas++;
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Can't find the File.");
            e.printStackTrace();
        }
       /* while (inputStream.available()>0){
          //  list.add(inputStream.read());
            int simbol=inputStream.read();
            if (simbol==44){
                numberOfCommas++;
            }
        }

        */
       // inputStream.close();
        //numberOfCommas= Collections.frequency(list, 44);
        System.out.println(numberOfCommas);
    }

}
