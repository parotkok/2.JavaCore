package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Объединение файлов

Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.

Требования:
Программа должна два раза считать имена файлов с консоли.
Не используй в программе статические переменные.
Для первого файла создай поток для чтения и считай его содержимое.
Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
Содержимое первого и второго файла нужно объединить в первом файле.
Сначала должно идти содержимое второго файла, затем содержимое первого.
Созданные для файлов потоки должны быть закрыты.
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        String fileName1=null;
        String fileName2=null;

        try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            fileName1=br.readLine();
            fileName2=br.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        List<Integer> list=new ArrayList<>();

        FileInputStream fis1=new FileInputStream(fileName1);
      //  byte[] buff1=new byte[fis1.available()];
        while (fis1.available()>0){
           // fis1.read(buff1);
            list.add(fis1.read());
        }
        fis1.close();
        FileInputStream fis2=new FileInputStream(fileName2);
      //  byte[] buff2=new byte[fis2.available()];
            while (fis2.available()>0){
                list.add(fis2.read());
              //  fis2.read(buff2);
            }
            fis2.close();
        FileOutputStream fos=new FileOutputStream(fileName1);
            for (int i=0; i<list.size(); i++){
                fos.write(list.get(i));
            }
          // fos.write(buff2);
          // fos.write(buff1);
            fos.close();


    }
}
