package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.Arrays;

/*
Реверс файла
читать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.

Требования:
Программа должна два раза считать имена файлов с консоли.
Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
Во второй файл нужно записать все байты из первого в обратном порядке.
Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/
public class Solution {
    public static void main(String[] args) {
        String fileName1=null;
        String fileName2=null;
        try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            fileName1=br.readLine();
            fileName2=br.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        try (FileInputStream inputStream=new FileInputStream(fileName1);
             FileOutputStream outputStream=new FileOutputStream(fileName2)){
            byte[] inFile=new byte[inputStream.available()];
            int count=0;
            while (inputStream.available()>0){
                count=inputStream.read(inFile);
            }
            for (int i=count-1; i>=0; i--){
                outputStream.write(inFile[i]);
            }
        }catch (FileNotFoundException e){
            System.out.println("Can't find the File!");
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
