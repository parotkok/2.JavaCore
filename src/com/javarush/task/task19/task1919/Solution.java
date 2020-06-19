package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/*
Считаем зарплаты

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0

Требования:
Программа НЕ должна считывать данные с консоли.
Программа должна считывать содержимое файла (используй FileReader).
Поток чтения из файла (FileReader) должен быть закрыт.
Программа должна выводить в консоль каждое имя и сумму всех его значений, все данные должны быть отсортированы в возрастающем порядке по имени.
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, Double> salary=new TreeMap<>();
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
        }
        for (Map.Entry pair:salary.entrySet()) {
            System.out.println(pair.getKey()+" "+pair.getValue());
        }
    }
}
