package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Округление чисел

Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4

Требования:
Программа должна два раза считать имена файлов с консоли.
Для первого файла создай поток для чтения. Для второго - поток для записи.
Считать числа из первого файла, округлить их и записать через пробел во второй.
Должны соблюдаться принципы округления, указанные в задании.
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
       
        BufferedReader reader=new BufferedReader(new FileReader(fileName1));
        FileWriter writer=new FileWriter(fileName2);
        while (reader.ready()){
            String str=reader.readLine();
            String[] strings=str.split(" ");
            int[] numbers=new int[strings.length];
            for (int i=0; i<strings.length; i++){
                double aDouble=Double.parseDouble(strings[i]);
                int n=(int) Math.round(aDouble);
                writer.write(n+" ");
                System.out.println(n);
            }
        }
        reader.close();
        writer.close();
    }
}
