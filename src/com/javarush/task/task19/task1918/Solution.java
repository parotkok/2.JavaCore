package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
Знакомство с тегами

Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, \n, \r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми

Требования:
Программа должна считывать имя файла с консоли (используй BufferedReader).
BufferedReader для считывания данных с консоли должен быть закрыт.
Программа должна считывать содержимое файла (используй FileReader).
Поток чтения из файла (FileReader) должен быть закрыт.
Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr=new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        String string=null;
        while (bfr.ready()){
            string+=bfr.readLine();
        }
        bfr.close();
        if (args.length>0) {
            String tag = args[0];
            Document document=Jsoup.parse(string);
            Elements list=document.select(tag);
            for (Element e:list) {
                System.out.println(e);
            }
        }
    }
}
