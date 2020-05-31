package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Собираем файл

Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.

Требования:
Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
В новый файл перепиши все байты из файлов-частей *.partN.
Чтение и запись должны происходить с использованием буфера.
Созданные для файлов потоки должны быть закрыты.
Не используй статические переменные.
*/
public class Solution {
    public static void main(String[] args) {
        List<String> fileNames=new ArrayList<>();

        try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String fileName = br.readLine();
                if (fileName.equals("end")) {
                    break;
                }
                fileNames.add(fileName);
            }
            Collections.sort(fileNames, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int indexO1=Integer.parseInt(o1.split(".part")[1]);
                    int indexO2=Integer.parseInt(o2.split(".part")[1]);
                    return indexO1-indexO2;
                }
            });
        }catch (IOException e) {
            e.printStackTrace();
        }

      try (FileOutputStream fileOutputStream=new FileOutputStream(fileNames.get(0).split(".part")[0])){
          for (int i=0; i<fileNames.size(); i++){
              try (FileInputStream fileInputStream = new FileInputStream(fileNames.get(i))) {
                  byte[] buff=new byte[fileInputStream.available()];
                  while (fileInputStream.available()>0){
                      fileInputStream.read(buff);
                      fileOutputStream.write(buff);
                  }

              } catch (FileNotFoundException e) {
                  System.out.println();
              }catch (IOException e){
                  e.printStackTrace();
              }
          }
          System.out.println("Combaine files is done!");
      }catch (FileNotFoundException e){
          e.printStackTrace();
      }catch (IOException e){
          e.printStackTrace();
      }



    }
}
