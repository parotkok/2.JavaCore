package com.javarush.task.task13.task1319;

import java.io.*;

/*
Писатель в файл с консоли
*/
/*
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.

Требования:
Программа должна считывать c консоли имя файла.
Создай и используй объект типа BufferedWriter.
Программа не должна ничего читать из файловой системы.
Программа должна считывать строки с консоли, пока пользователь не введет строку "exit".
Программа должна записать абсолютно все введенные строки (включая "exit") в файл, каждую строчку с новой строки.
Метод main должен закрывать объект типа BufferedWriter после использования.
Метод main не должен выводить данные на экран.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));

        String s = "";
        while (!s.equals("exit")) {
            s = bufferedReader.readLine();
            writer.write(s);
            writer.newLine();
        }

        writer.close();
        bufferedReader.close();
    }
}
