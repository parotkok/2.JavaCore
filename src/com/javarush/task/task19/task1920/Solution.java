package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
Самый богатый

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров

Требования:
Программа НЕ должна считывать данные с консоли.
Программа должна считывать содержимое файла (используй FileReader).
Поток чтения из файла (FileReader) должен быть закрыт.
Программа должна выводить в консоль имена, у которых максимальная сумма.
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, Double> salary=new TreeMap<>();
        Set<String> rich=new TreeSet<>();
        if (args.length>0){
            try (BufferedReader br=new BufferedReader(new FileReader(args[0]))){
                while (br.ready()){
                    String [] line=br.readLine().split("\\s");
                    try {
                        if (!salary.containsKey(line[0])){
                            salary.put(line[0], Double.parseDouble(line[1]));
                        }
                        else {
                            salary.replace(line[0], salary.get(line[0])+Double.parseDouble(line[1]));
                        }
                    }catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                }

            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
            double richest=Double.MIN_VALUE;
            for (Double d:salary.values()) {
                if (richest<d){
                    richest=d;
                }
            }
            double threshold=0.000000000000001;
            for (Map.Entry<String,Double> pair:salary.entrySet()) {
                if (Math.abs(pair.getValue()-richest)<=threshold){
                    System.out.println(pair.getKey());
                }
            }


        }

    }

}

