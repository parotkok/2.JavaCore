package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.IOException;

/*
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.

Требования:
Считывать с консоли ничего не нужно.
Создай поток чтения из файла, который приходит первым параметром в main.
В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
Нужно учитывать заглавные и строчные буквы.
Поток чтения из файла должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        int count=0;
        FileInputStream fis=new FileInputStream(args[0]);
        int i;
        while ((i=fis.read())!=-1){
            if ((i>=65&&i<=90)||(i>=97&&i<=122)){
                count++;
            }
        }
        fis.close();
        System.out.println(count);
    }

}
