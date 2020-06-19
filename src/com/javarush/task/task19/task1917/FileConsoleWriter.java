package com.javarush.task.task19.task1917;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

/*
Свой FileWriter

Реализовать логику FileConsoleWriter.
Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter.
Класс FileConsoleWriter должен содержать все конструкторы, которые инициализируют fileWriter для записи.
Класс FileConsoleWriter должен содержать пять методов write и один метод close:

public void write(char[] cbuf, int off, int len) throws IOException
public void write(int c) throws IOException
public void write(String str) throws IOException
public void write(String str, int off, int len) throws IOException
public void write(char[] cbuf) throws IOException
public void close() throws IOException
При записи данных в файл, должен дублировать эти данные на консоль.

Требования:
Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter, которое не должно быть сразу проинициализировано.
Класс FileConsoleWriter должен иметь пять конструкторов которые инициализируют fileWriter для записи.
Класс FileConsoleWriter должен содержать метод write(char[] cbuf, int off, int len) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
Класс FileConsoleWriter должен содержать метод write(int c) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
Класс FileConsoleWriter должен содержать метод write(String str) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
Класс FileConsoleWriter должен содержать метод write(String str, int off, int len) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
Класс FileConsoleWriter должен содержать метод write(char[] cbuf) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
Класс FileConsoleWriter должен содержать метод close() throws IOException, в котором должен вызываться такой же метод поля fileWriter.
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
