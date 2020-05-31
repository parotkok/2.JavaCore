package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.

Требования:
Считывать с консоли ничего не нужно.
Создай поток чтения из файла, который приходит первым параметром в main.
Посчитай отношение пробелов ко всем символам в файле и выведи в консоль это число.
Выведенное значение необходимо округлить до 2 знаков после запятой.
Поток чтения из файла должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        int simbols=0;
        int spases=0; //spase==32
        int i;
        try (FileInputStream fis=new FileInputStream(args[0])){
            while ((i=fis.read())!=-1){
                if (i==32){
                    spases++;
                }else {
                    simbols++;
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        double result=(double) spases*100.0/(simbols+spases);
        System.out.printf("%.2f", result);

    }
}
