package com.javarush.task.task19.task1923;

import java.io.*;

/*
Слова с цифрами

В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.

Требования:
Программа НЕ должна считывать данные с консоли.
Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
Поток чтения из файла (FileReader) должен быть закрыт.
Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
Поток записи в файл (FileWriter) должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) {
        if (args.length>1){
            try (BufferedReader fileReader=new BufferedReader(new FileReader(args[0]));
                 BufferedWriter fileWriter=new BufferedWriter(new FileWriter(args[1]))){
                while (fileReader.ready()){
                    String[] words=fileReader.readLine().split("\\s");
                    for (String s:words) {
                        if (s.matches("\\d+")){
                            fileWriter.write(s+" ");
                        }
                    }
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
