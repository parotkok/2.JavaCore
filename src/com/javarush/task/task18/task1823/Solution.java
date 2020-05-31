package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/*
Нити и байты

Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.

Требования:
Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
Для каждого файла создай нить ReadThread и запусти ее.
После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
Поток для чтения из файла в каждой нити должен быть закрыт.
*/
public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String fileName = reader.readLine();
            if (fileName.equals("exit")) {
                break;
            }
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
        }

        for (Map.Entry entry:resultMap.entrySet()) {
            System.out.printf("The file %s has most frequently byte: %d.\n", entry.getKey(), entry.getValue());

        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        int maxValue;

        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }
        @Override
        public void run() {
            List<Integer> list=new ArrayList<>();
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available() > 0) {
                    list.add(fileInputStream.read());
                }
                fileInputStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            maxValue = list.get(0);
            int maxCount = Collections.frequency(list, maxValue);
            for (int i=1; i<list.size(); i++){
                int currentValue=list.get(i);
                int currentCount=Collections.frequency(list, currentValue);
                if (currentCount>maxCount){
                    maxCount=currentCount;
                    maxValue=currentValue;
                }
            }

            synchronized (resultMap){
                resultMap.put(this.fileName, this.maxValue);
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
