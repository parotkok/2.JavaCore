package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
Замена чисел

1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.

Требования:
Класс Solution должен содержать публичное статическое поле map типа Map<Integer, String>, которое должно быть сразу проинициализировано.
Программа должна считывать имя файла с консоли (используй BufferedReader).
BufferedReader для считывания данных с консоли должен быть закрыт.
Программа должна считывать содержимое файла (используй FileReader).
Поток чтения из файла (FileReader) должен быть закрыт.
Программа должна выводить в консоль все строки из файла, но числа должны быть заменены на слова из словаря map.
Класс Solution должен содержать статический блок, в котором добавляются в map тринадцать пар.
*/
public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }
    public static void main(String[] args){
        String fileName=null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName=reader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        try (BufferedReader bfr = new BufferedReader(new FileReader(fileName))){
           while (bfr.ready()){
               String line = bfr.readLine();

               for (Map.Entry<Integer, String> pair : map.entrySet())
                   line = line.replaceAll("\\b" + pair.getKey().toString() + "\\b", pair.getValue());
               System.out.println(line);
               /*
               String[] words=line.split("\\s");
               StringBuffer stringBuffer=new StringBuffer();
               for (int i=0; i<words.length; i++) {
                   for (Map.Entry<Integer, String> pair:map.entrySet()) {
                       if (words[i].equals(pair.getKey().toString())){
                           words[i]=pair.getValue();
                       }
                   }
                   stringBuffer.append(words[i]+" ");
               }
               System.out.println(stringBuffer.toString().trim());
                */
           }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
