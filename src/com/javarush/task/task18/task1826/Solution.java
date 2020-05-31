package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Шифровка

Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.

Требования:
Считывать с консоли ничего не нужно.
Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
Созданные для файлов потоки должны быть закрыты.
*/
public class Solution {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream=new FileInputStream(args[1]);
             FileOutputStream fileOutputStream=new FileOutputStream(args[2])){
            if (args[0].equals("-e")) {
                while (fileInputStream.available() > 0) {

                    fileOutputStream.write(fileInputStream.read() + 5);
                }
            }

            if (args[0].equals("-d")){
                while (fileInputStream.available() > 0) {

                    fileOutputStream.write(fileInputStream.read() - 5);
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
