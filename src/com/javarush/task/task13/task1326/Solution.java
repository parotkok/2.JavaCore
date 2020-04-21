package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
Сортировка четных чисел из файла
*/
/*
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
-2
11
3
-5
2
10

Пример вывода:
-2
2
8
10

Требования:
Программа должна считывать данные с консоли.
Программа должна создавать FileInputStream для введенной с консоли строки.
Программа должна выводить данные на экран.
Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
Программа должна закрывать поток чтения из файла(FileInputStream).
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();
        try {
            BufferedReader fileReader=new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
            while (fileReader.ready()) {
                list.add(Integer.parseInt(fileReader.readLine()));
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                System.out.println(list.get(i));
            }
        }
    }
}
