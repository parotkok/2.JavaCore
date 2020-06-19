package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Ищем нужные строки

Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.

Пример:
words содержит слова А, Б, В

Строки:
В Б А Д //3 слова из words, не подходит
А Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова - подходит, выводим
Д А А Д //2 слова - подходит, выводим

Требования:
Класс Solution должен содержать публичное статическое поле words типа List<String>, которое должно быть сразу проинициализировано.
Класс Solution должен содержать статический блок, в котором добавляются три или больше слов в список words.
Программа должна считывать имя файла с консоли (используй BufferedReader).
BufferedReader для считывания данных с консоли должен быть закрыт.
Программа должна считывать содержимое файла (используй FileReader).
Поток чтения из файла (FileReader) должен быть закрыт.
Программа должна выводить в консоль все строки из файла, которые содержат всего 2 слова из списка words.
*/
public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        String fileName=null;
        try (BufferedReader console=new BufferedReader(new InputStreamReader(System.in))){
            fileName=console.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        try (BufferedReader fileReader=new BufferedReader(new FileReader(fileName))){
            while (fileReader.ready()){
                String line=fileReader.readLine();
                String[] word=line.split("[\\s\\p{Punct}\\p{Cntrl}]");
                int count=0;
                for (String s:word) {
                    for (String ss:words) {
                        if (s.equals(ss)){
                            count++;
                        }
                    }
                }
                if (count==2){
                    System.out.println(line);
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
