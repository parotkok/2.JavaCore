package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
Файл в статическом блоке
*/
/*
1. Инициализируй переменную Statics.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Statics.FILE_NAME все строки и добавь их по отдельности в List lines.

Требования:
Константа FILE_NAME не должна быть пустой.
В статическом блоке все строки из файла с именем FILE_NAME должны быть добавлены по-отдельности в список lines.
Поле FILE_NAME НЕ должно быть final.
Класс Solution должен содержать список lines.
 */
public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static
    {
        try(FileReader fr = new FileReader(Statics.FILE_NAME))
        {
            BufferedReader reader=new BufferedReader(fr);
            String line=reader.readLine();
            while (line!=null)
            {
                Solution.lines.add(line);
                line = reader.readLine();
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        for(String s: lines)
        {System.out.println(s);}
    }
}
