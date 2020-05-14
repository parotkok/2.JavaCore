package com.javarush.task.task17.task1721;
/*
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.

Требования:
Класс Solution должен содержать public static поле allLines типа List<String>.
Класс Solution должен содержать public static поле forRemoveLines типа List<String>.
Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException.
Программа должна считывать c консоли имена двух файлов.
Программа должна считывать построчно данные из первого файла в список allLines.
Программа должна считывать построчно данные из второго файла в список forRemoveLines.
Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines содержаться все строки из списка forRemoveLines.
Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines не содержаться все строки из списка forRemoveLines.
Метод joinData должен вызываться в main.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String firstFile = br.readLine();
            String secondFile = br.readLine();
            br.close();

            try (BufferedReader bufferedFileReader=new BufferedReader(new FileReader(firstFile))){

                while (bufferedFileReader.ready()){
                    allLines.add(bufferedFileReader.readLine());
                }
            }catch (FileNotFoundException e){
                System.out.println("File " + firstFile + " not found");
            }

            try (BufferedReader bufferedFileReader=new BufferedReader(new FileReader(secondFile))){
                while (bufferedFileReader.ready()){
                    forRemoveLines.add(bufferedFileReader.readLine());
                }
            }catch (FileNotFoundException e){
                System.out.println("File " + secondFile + " not found");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new Solution().joinData();
        }catch (CorruptedDataException e){
            System.out.println("Something was wrong!");
        }
    }

    public void joinData() throws CorruptedDataException {
        boolean isPresent = false;
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
            //System.out.println(allLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
