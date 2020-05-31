package com.javarush.task.task18.task1828;
/*
Прайсы 2

CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id - 8 символов
productName - название товара, 30 символов
price - цена, 8 символов
quantity - количество, 4 символа
-u - обновляет данные товара с заданным id
-d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234

Требования:
Программа должна считать имя файла для операций CrUD с консоли.
При запуске программы без параметров список товаров должен остаться неизменным.
При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String fileName=null;
        try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
            fileName=br.readLine();             //reading the fileName
        }catch (IOException e){
            e.printStackTrace();
        }
        if (args.length<=0) {  //if there are no args
            System.out.println("Not require args!");
            return;
        }
        else {
            if (args[0].equals("-d")&&args.length>=2){
                int idToDel=0;
                List<String> fileStrings=readFile(fileName);
                try {
                    idToDel=Integer.parseInt(args[1].trim());
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
                for (int i=0; i<fileStrings.size(); i++){
                    try {
                        int id=Integer.parseInt(fileStrings.get(i).substring(0, 8).trim());

                        if (idToDel==id){
                            fileStrings.remove(i);
                        }
                    }catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                }
                writeFile(fileName, fileStrings);
            }
            if (args[0].equals("-u")&&args.length>=5){
                int idToUpd=0;
                String productName=args[2];
                double price=0.0;
                int quantity=0;
                List<String> fileStrings=readFile(fileName);
                try {
                    idToUpd=Integer.parseInt(args[1].trim());
                    price=Double.parseDouble(args[3].trim());
                    quantity=Integer.parseInt(args[4].trim());
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
                for (int i=0; i<fileStrings.size(); i++){
                    try {
                        int id=Integer.parseInt(fileStrings.get(i).substring(0, 8).trim());
                        if (idToUpd==id){
                            fileStrings.set(i, String.format("%-8d%-30.30s%-8.2f%-4d", idToUpd, productName, price, quantity));
                        }
                    }catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                }
                writeFile(fileName, fileStrings);
            }
            System.out.println("The job is done!");
        }
    }

    public static List<String> readFile(String fileName){
        List<String> fileStrings=new ArrayList<>();
        try (BufferedReader br=new BufferedReader(new FileReader(fileName))){
            while (br.ready()){
                fileStrings.add(br.readLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("No such file!");
        }catch (IOException e){
            e.printStackTrace();
        }
        return fileStrings;
    }

    public static void writeFile(String fileName, List<String> fileStrings){
        try (BufferedWriter bw=new BufferedWriter(new FileWriter(fileName))){
            for (String s:fileStrings) {
                bw.write(s);
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
