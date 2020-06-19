package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
Хуан Хуанович

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013

Требования:
Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть сразу проинициализирована.
Программа НЕ должна считывать данные с консоли.
Программа должна считывать содержимое файла (используй FileReader).
Поток чтения из файла (FileReader) должен быть закрыт.
Программа должна заполнить список PEOPLE данными из файла.
Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/
public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args){
        if (args.length>0){
            try (BufferedReader reader=new BufferedReader(new FileReader(args[0]))){
                while (reader.ready()){
                    String line=reader.readLine();
                    String name=line.replaceAll("[\\d]", "").trim();
                    String date=line.substring(name.length()).trim();
                    SimpleDateFormat dateFormat=new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
                    PEOPLE.add(new Person(name.trim(), dateFormat.parse(date.trim())));
                }
               /* for (Person p:PEOPLE) {
                    System.out.println(p.getName()+" "+p.getBirthDate());
                } */
            }catch (ParseException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }
}
