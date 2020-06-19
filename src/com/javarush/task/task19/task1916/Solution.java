package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
ќтслеживаем изменени€

—читать с консоли 2 имени файла - file1, file2.
‘айлы содержат строки, file2 €вл€етс€ обновленной версией file1, часть строк совпадают.
Ќужно создать объединенную версию строк, записать их в список lines.
ќперации ADDED и REMOVED не могут идти подр€д, они всегда разделены SAME.
ѕустые строки даны в примере дл€ нагл€дности.
¬ оригинальном и редактируемом файлах пустых строк нет!

ѕример 1:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0

ѕример 2:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
                строка0            ADDED строка0

ѕустые строки в примере означают, что этой строки нет в определенном файле.

“ребовани€:
 ласс Solution должен содержать класс LineItem.
 ласс Solution должен содержать enum Type.
 ласс Solution должен содержать публичное статическое поле lines типа List<LineItem>, которое сразу проинициализировано.
¬ методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
¬ методе main(String[] args) BufferedReader дл€ считывани€ данных с консоли должен быть закрыт.
ѕрограмма должна считывать содержимое первого и второго файла (используй FileReader).
ѕотоки чтени€ из файлов (FileReader) должны быть закрыты.
—писок lines должен содержать объединенную версию строк из файлов, где дл€ каждой строки указана одна из операций ADDED, REMOVED, SAME.
*/
public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bfrOne = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader bfrTwo = new BufferedReader(new FileReader(reader.readLine()));
        List<String> listOne = bfrOne.lines().collect(Collectors.toList());
        List<String> listTwo = bfrTwo.lines().collect(Collectors.toList());
        reader.close();
        bfrOne.close();
        bfrTwo.close();

        int n1=0;
        int n2=0;
        while (n1<listOne.size()||n2<listTwo.size()){

            if (!listOne.get(n1).equals(listTwo.get(n2))){
                if ((n2+1)<listTwo.size()&&listOne.get(n1).equals(listTwo.get(n2+1))){
                    lines.add(new LineItem(Type.ADDED, listTwo.get(n2)));
                    lines.add(new LineItem(Type.SAME, listOne.get(n1)));
                    n2++;
                }
                else {
                    if ((n1+1)<listOne.size()&&listOne.get(n1+1).equals(listTwo.get(n2))){
                    lines.add(new LineItem(Type.REMOVED, listOne.get(n1)));
                    lines.add(new LineItem(Type.SAME, listTwo.get(n2)));
                    n1++;
                    }
                }
            }else {
                lines.add(new LineItem(Type.SAME, listOne.get(n1)));
            }
            if (n1<(listOne.size()-1)){
                n1++;
            }else {
                if (n2<(listTwo.size()-1)){
                    n2++;
                    lines.add(new LineItem(Type.ADDED, listTwo.get(n2)));
                }
            }
            if (n2<listTwo.size()-1){
                n2++;
            }else {
                if (n1<(listOne.size()-1)){
                    n1++;
                    lines.add(new LineItem(Type.REMOVED, listOne.get(n1)));
                }
            }
            if (n1==(listOne.size()-1)&&n2==(listTwo.size()-1)){
                n1++;
                n2++;
            }
        }

        for (LineItem i:lines) {
            System.out.println(i.type+" - "+i.line);
        }

    }
    public static enum Type {
        ADDED,        //добавлена нова€ строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }
    public static class LineItem {
        public Type type;
        public String line;
        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
