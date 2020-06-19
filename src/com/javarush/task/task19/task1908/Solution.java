package com.javarush.task.task19.task1908;
/*
Выделяем числа

Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1

Требования:
Программа должна считывать имена файлов с консоли (используй BufferedReader).
BufferedReader для считывания данных с консоли должен быть закрыт.
Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
Поток чтения из файла (BufferedReader) должен быть закрыт.
Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
Поток записи в файл (BufferedWriter) должен быть закрыт.

*/

import java.io.*;

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
                String[] strings=br.readLine().split("\\s");
                for (String s:strings) {
                    try {
                        int number=Integer.parseInt(s);
                        bw.write(number+" ");
                    }catch (NumberFormatException e){
                        continue;
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
