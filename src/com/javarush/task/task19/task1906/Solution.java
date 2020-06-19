package com.javarush.task.task19.task1906;

import java.io.*;

/*
Четные символы

Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод

Требования:
Программа должна считывать имена файлов с консоли (используй BufferedReader).
BufferedReader для считывания данных с консоли должен быть закрыт.
Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
Поток чтения из файла (FileReader) должен быть закрыт.
Программа должна записывать во второй файл все байты из первого файла с четным порядковым номером (используй FileWriter).
Поток записи в файл (FileWriter) должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) {
        String filename1=null;
        String filename2=null;
        try (BufferedReader console=new BufferedReader(new InputStreamReader(System.in))){
           filename1=console.readLine();
           filename2=console.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }

        try (FileReader fileReader=new FileReader(filename1);
             FileWriter fileWriter=new FileWriter(filename2))   {
            int count=0;
            while (fileReader.ready()){
                int simbol=fileReader.read();
                count++;
                if (count%2==0){
                    fileWriter.write(simbol);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
