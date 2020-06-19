package com.javarush.task.task19.task1917;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

/*
���� FileWriter

����������� ������ FileConsoleWriter.
����� FileConsoleWriter ������ ��������� ��������� ���� FileWriter fileWriter.
����� FileConsoleWriter ������ ��������� ��� ������������, ������� �������������� fileWriter ��� ������.
����� FileConsoleWriter ������ ��������� ���� ������� write � ���� ����� close:

public void write(char[] cbuf, int off, int len) throws IOException
public void write(int c) throws IOException
public void write(String str) throws IOException
public void write(String str, int off, int len) throws IOException
public void write(char[] cbuf) throws IOException
public void close() throws IOException
��� ������ ������ � ����, ������ ����������� ��� ������ �� �������.

����������:
����� FileConsoleWriter ������ ��������� ��������� ���� FileWriter fileWriter, ������� �� ������ ���� ����� �������������������.
����� FileConsoleWriter ������ ����� ���� ������������� ������� �������������� fileWriter ��� ������.
����� FileConsoleWriter ������ ��������� ����� write(char[] cbuf, int off, int len) throws IOException, � ������� ������ ��� ������ ������ ������������ � fileWriter � ������������� � �������.
����� FileConsoleWriter ������ ��������� ����� write(int c) throws IOException, � ������� ������ ��� ������ ������ ������������ � fileWriter � ������������� � �������.
����� FileConsoleWriter ������ ��������� ����� write(String str) throws IOException, � ������� ������ ��� ������ ������ ������������ � fileWriter � ������������� � �������.
����� FileConsoleWriter ������ ��������� ����� write(String str, int off, int len) throws IOException, � ������� ������ ��� ������ ������ ������������ � fileWriter � ������������� � �������.
����� FileConsoleWriter ������ ��������� ����� write(char[] cbuf) throws IOException, � ������� ������ ��� ������ ������ ������������ � fileWriter � ������������� � �������.
����� FileConsoleWriter ������ ��������� ����� close() throws IOException, � ������� ������ ���������� ����� �� ����� ���� fileWriter.
*/
public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fileDescriptor) {
        this.fileWriter = new FileWriter(fileDescriptor);
    }

    public void write(char[] cbuf,int off,int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.println(new String(cbuf).substring(off, off + len));
    }
    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }
    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }
    public void write(String str,int off,int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off + len));
    }
    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.println(new String (cbuf));
    }
    public void close() throws IOException {
        fileWriter.close();

    }
    public static void main(String[] args) throws IOException {
        //FileConsoleWriter fileConsoleWriter=new FileConsoleWriter("D://1.txt");
        //char [] c=new char[]{1, 2, 3};
        //fileConsoleWriter.write(c);
        //String s="Hello world!";
        //fileConsoleWriter.write(s);
        //fileConsoleWriter.close();
    }

}
