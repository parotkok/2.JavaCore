package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/*
Встречаемость символов

Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361

Требования:
Считывать с консоли ничего не нужно.
Создай поток для чтения из файла, который приходит первым параметром в main.
В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
Поток для чтения из файла должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fis=new FileInputStream(args[0]);
        List<Integer> list=new ArrayList<>();
        while (fis.available()>0){
            list.add(fis.read());
        }
        fis.close();
        Map<Character,Integer> result=new TreeMap<>();
        for (int key:list) {
            int val= Collections.frequency(list, key);
            result.put((char) key, val);
        }

        for (Map.Entry entry:result.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
