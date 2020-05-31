package com.javarush.task.task18.task1818;
/*
Два в одном

Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.

Требования:
Программа должна три раза считать имена файлов с консоли.
Для первого файла создай поток для записи. Для двух других - потоки для чтения.
Содержимое второго файла нужно переписать в первый файл.
Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName1=null;
        String fileName2=null;
        String fileName3=null;

        try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            fileName1=br.readLine();
            fileName2=br.readLine();
            fileName3=br.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        try (FileOutputStream fos=new FileOutputStream(fileName1, true);
             FileInputStream fis1=new FileInputStream(fileName2);
             FileInputStream fis2=new FileInputStream(fileName3))
        {
         while (fis1.available()>0){
             fos.write(fis1.read());
         }
         while (fis2.available()>0){
             fos.write(fis2.read());
         }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
