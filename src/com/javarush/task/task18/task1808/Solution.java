package com.javarush.task.task18.task1808;

import java.io.*;

/*
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.

Требования:
Программа должна три раза считать имена файлов с консоли.
Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
Первую половину байт из первого файла нужно записать во второй файл.
Вторую половину байт из первого файла нужно записать в третий файл.
Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/
public class Solution {
    public static void main(String[] args) {
        String fileNameIn=null;
        String fileNameOut1=null;
        String fileNameOut2=null;
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            fileNameIn=br.readLine();
            fileNameOut1=br.readLine();
            fileNameOut2=br.readLine();

        }catch (IOException e){
            e.printStackTrace();
        }

        try (FileInputStream inputStream=new FileInputStream(fileNameIn);
             FileOutputStream outputStream1=new FileOutputStream(fileNameOut1);
             FileOutputStream outputStream2=new FileOutputStream(fileNameOut2)) {

            byte[] buffFileOut1=new byte[inputStream.available()-inputStream.available()/2];
            byte[] buffFileOut2=new byte[inputStream.available()-buffFileOut1.length];

            while (inputStream.available()>0){
                int count=inputStream.read(buffFileOut1);
                outputStream1.write(buffFileOut1, 0, count);
                int count2=inputStream.read(buffFileOut2);
                outputStream2.write(buffFileOut2, 0, count2);
            }

        }catch (FileNotFoundException e){
            System.out.println("Can't find the File");
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
