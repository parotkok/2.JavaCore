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
���������� � ������

�������� � ������� ��� �����, ������� ����� HTML-������.

������:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

������ ���������� � ����� main �������� ���. ��������, "span".
������� �� ������� ��� ����, ������� ������������� ��������� ����.
������ ��� �� ����� ������, ������� ������ ��������������� ������� ���������� � �����.
���������� ��������, \n, \r �� ������ �� ���������.
���� �� �������� ��� CDATA, ��� ���� ����������� ����� ������� ��������� ����������� ���, ��������� ����� ���.
��� ����� ��������� ��������� ����.

������ ������:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

������ ����:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 ����� ���� �������

����������:
��������� ������ ��������� ��� ����� � ������� (��������� BufferedReader).
BufferedReader ��� ���������� ������ � ������� ������ ���� ������.
��������� ������ ��������� ���������� ����� (��������� FileReader).
����� ������ �� ����� (FileReader) ������ ���� ������.
��������� ������ �������� � ������� ��� ����, ������� ������������� ����, ��������� � ��������� ������ main.
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
