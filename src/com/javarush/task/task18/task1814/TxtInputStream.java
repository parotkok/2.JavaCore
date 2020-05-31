package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;

/*
UnsupportedFileName
Измени класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt).
Например, first.txt или name.1.part3.txt.
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException.
Подумай, что еще нужно сделать, в случае выброшенного исключения.

Требования:
Класс TxtInputStream должен наследоваться от класса FileInputStream.
Если в конструктор передан txt-файл, TxtInputStream должен вести себя, как обычный FileInputStream.
Если в конструктор передан не txt-файл, должно быть выброшено исключение UnsupportedFileNameException.
В случае выброшенного исключения, так же должен быть вызван super.close().
*/
public class TxtInputStream extends FileInputStream {
    FileInputStream component;

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);

        if (fileName.endsWith(".txt")) {
            component = new FileInputStream(fileName);
        }
        else {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    @Override
    public int read() throws IOException {
        return component.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return component.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return component.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return component.skip(n);
    }

    @Override
    public int available() throws IOException {
        return component.available();
    }

    @Override
    public void close() throws IOException {
        super.close();
        component.close();
    }

    @Override
    public FileChannel getChannel() {
        return component.getChannel();
    }

    public static void main(String[] args) {
    }
}
