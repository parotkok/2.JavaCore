package com.javarush.task.task19.task1925;

import java.io.*;

/*
Длинные слова

В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура

Требования:
Программа НЕ должна считывать данные с консоли.
Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
Поток чтения из файла (FileReader) должен быть закрыт.
Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
Поток записи в файл (FileWriter) должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) {
        if (args.length>1){
            try (BufferedReader fileReader=new BufferedReader(new FileReader(args[0]));
                 BufferedWriter fileWriter=new BufferedWriter(new FileWriter(args[1]))){
                StringBuffer stringBuffer=new StringBuffer();
                while (fileReader.ready()){
                    String s=fileReader.readLine().trim();
                    String[] words=s.split("\\s");
                    for (String str:words) {
                        if (str.length()>6){
                            stringBuffer.append(str+" ");
                        }
                    }
                }

                fileWriter.write(stringBuffer.toString().trim().replaceAll("\\s", ","));
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
