package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Чтение файла
*/
/*
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.

Требования:
Программа должна считывать c консоли имя файла.
Программа должна выводить на экран содержимое файла.
Поток чтения из файла (FileInputStream) должен быть закрыт.
BufferedReader также должен быть закрыт.
 */
public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            FileInputStream input = new FileInputStream(name);

            while (input.available() > 0) {
                System.out.print((char) input.read());
            }

            reader.close();
            input.close();
        }
        catch (Exception name) {

        }
    }
}
