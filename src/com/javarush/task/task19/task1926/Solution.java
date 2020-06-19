package com.javarush.task.task19.task1926;

import java.io.*;
import java.util.Map;

/*
�����������

1. ������� � ������� ��� �����. ������� ���������� �����.
2. ��� ������ ������ � �����:
2.1. ����������� ��� ������� � �������� �������.
2.2. ������� �� �����.
3. ������� ������.

������ ���� �������� �����:
� - �����������.
�����

������ ����������:
.����������� - �
�����

����������:
��������� ������ ��������� ��� ����� � ������� (��������� BufferedReader).
BufferedReader ��� ���������� ������ � ������� ������ ���� ������.
��������� ������ ��������� ���������� ����� (��������� FileReader).
����� ������ �� ����� (FileReader) ������ ���� ������.
��������� ������ �������� � ������� ��� ������� �� ����� � �������� �������.
*/
public class Solution {
    public static void main(String[] args) {
        String fileName=null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName=reader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        try (BufferedReader bfr = new BufferedReader(new FileReader(fileName))){
            while (bfr.ready()){
                String line = bfr.readLine();
                StringBuffer a = new StringBuffer(line);
                System.out.println(a.reverse());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
