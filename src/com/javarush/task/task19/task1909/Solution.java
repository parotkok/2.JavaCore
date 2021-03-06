package com.javarush.task.task19.task1909;

import java.io.*;

/*
Замена знаков

Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла и заменить все точки "." на знак "!".
Результат вывести во второй файл.
Закрыть потоки.

Требования:
Программа должна считывать имена файлов с консоли (используй BufferedReader).
BufferedReader для считывания данных с консоли должен быть закрыт.
Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
Поток чтения из файла (BufferedReader) должен быть закрыт.
Программа должна записывать во второй файл содержимое первого файла, где заменены все точки "." на знак "!" (Для записи в файл используй BufferedWriter с конструктором FileWriter).
Поток записи в файл (BufferedWriter) должен быть закрыт.
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

        try (BufferedReader br=new BufferedReader(new FileReader(filename1));
             BufferedWriter bw=new BufferedWriter(new FileWriter(filename2)))   {

            while (br.ready()){
                String string=br.readLine().replaceAll("\\.", "!");
                bw.write(string+"\n");

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
