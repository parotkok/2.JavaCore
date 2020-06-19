package com.javarush.task.task19.task1925;

import java.io.*;

/*
������� �����

� ����� main ������ ���������� �������� ��� �����1, ������ - �����2.
����1 �������� �����, ����������� ��������.
�������� ����� ������� � ����2 �����, ����� ������� ������ ������ 6.
� ����� �����2 ������� �� ������ ����.
������� ������.

������ �������� ������ � ����2:
�������,��������,������������

����������:
��������� �� ������ ��������� ������ � �������.
��������� ������ ��������� ���������� ������� ����� (��������� FileReader c ������������� String).
����� ������ �� ����� (FileReader) ������ ���� ������.
��������� ������ ���������� ����� ������� �� ������ ���� ��� ����� �� ������� ����� ����� ������� ������ ������ 6(��������� FileWriter).
����� ������ � ���� (FileWriter) ������ ���� ������.
*/
public class Solution {
    public static void main(String[] args) {
        if (args.length>1){
            try (BufferedReader fileReader=new BufferedReader(new FileReader(args[0]));
                 BufferedWriter fileWriter=new BufferedWriter(new FileWriter(args[1]))){
                StringBuffer stringBuffer=new StringBuffer();
                while (fileReader.ready()){
                    String s=fileReader.readLine().trim();
                    String[] words=s.split("\\s");
                    for (String str:words) {
                        if (str.length()>6){
                            stringBuffer.append(str+" ");
                        }
                    }
                }

                fileWriter.write(stringBuffer.toString().trim().replaceAll("\\s", ","));
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
