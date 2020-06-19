package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
����������� ���������

������� � ������� 2 ����� ����� - file1, file2.
����� �������� ������, file2 �������� ����������� ������� file1, ����� ����� ���������.
����� ������� ������������ ������ �����, �������� �� � ������ lines.
�������� ADDED � REMOVED �� ����� ���� ������, ��� ������ ��������� SAME.
������ ������ ���� � ������� ��� �����������.
� ������������ � ������������� ������ ������ ����� ���!

������ 1:
������������    ���������������    �����
file1:          file2:             ���������:(lines)

������1         ������1            SAME ������1
������2                            REMOVED ������2
������3         ������3            SAME ������3
������4                            REMOVED ������4
������5         ������5            SAME ������5
                ������0            ADDED ������0
������1         ������1            SAME ������1
������2                            REMOVED ������2
������3         ������3            SAME ������3
                ������4            ADDED ������4
������5         ������5            SAME ������5
������0                            REMOVED ������0

������ 2:
������������    ���������������    �����
file1:          file2:             ���������:(lines)

������1         ������1            SAME ������1
                ������0            ADDED ������0

������ ������ � ������� ��������, ��� ���� ������ ��� � ������������ �����.

����������:
����� Solution ������ ��������� ����� LineItem.
����� Solution ������ ��������� enum Type.
����� Solution ������ ��������� ��������� ����������� ���� lines ���� List<LineItem>, ������� ����� �������������������.
� ������ main(String[] args) ��������� ������ ��������� ����� ������ � ������� (��������� BufferedReader).
� ������ main(String[] args) BufferedReader ��� ���������� ������ � ������� ������ ���� ������.
��������� ������ ��������� ���������� ������� � ������� ����� (��������� FileReader).
������ ������ �� ������ (FileReader) ������ ���� �������.
������ lines ������ ��������� ������������ ������ ����� �� ������, ��� ��� ������ ������ ������� ���� �� �������� ADDED, REMOVED, SAME.
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
        ADDED,        //��������� ����� ������
        REMOVED,      //������� ������
        SAME          //��� ���������
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
