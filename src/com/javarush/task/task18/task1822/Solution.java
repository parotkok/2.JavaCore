package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Поиск данных внутри файла

Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

Информация по каждому товару хранится в отдельной строке.

Требования:
Программа должна считать имя файла с консоли.
Создай для файла поток для чтения.
Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
Поток для чтения из файла должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader=new BufferedReader(new FileReader(br.readLine()));
        br.close();

        while (reader.ready()){
            String string=reader.readLine();
            if (string.startsWith(args[0]+" ")){
                System.out.println(string);
                break;
            }
        }
        reader.close();

    }
}
