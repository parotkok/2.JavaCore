package com.javarush.task.task18.task1827;

import java.io.*;
import java.lang.reflect.InaccessibleObjectException;

/*
Прайсы

CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234

Требования:
Программа должна считать имя файла для операций CrUD с консоли.
В классе Solution не должны быть использованы статические переменные.
При запуске программы без параметров список товаров должен остаться неизменным.
При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
Товар должен иметь следующий id, после максимального, найденного в файле.
Форматирование новой строки товара должно четко совпадать с указанным в задании.
Созданные для файлов потоки должны быть закрыты.
*/
public class Solution {
    public static void main(String[] args) {

        if (args.length<4||!args[0].equals("-c")) {  //if there are not require args & the first args is not "-c"
            System.out.println("Not require args!");
            return;
        }
        else {
            String fileName=null;
            double price=0.0;
            int quantity=0;
            try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
                fileName=br.readLine();             //reading the fileName
            }catch (IOException e){
                e.printStackTrace();
            }

            try {
                price=Double.parseDouble(args[args.length-2]);
                quantity=Integer.parseInt(args[args.length-1]);
            }catch (NumberFormatException e){
                System.out.println("the data not valid");
                return;
            }

            //if we have more than 4 args because of spaces in productName
            String productName;
            if (args.length > 4) {
                StringBuffer buf = new StringBuffer();
                for (int i = 1; i < args.length - 2; i++)
                    buf.append(args[i]).append(" ");
                productName = buf.substring(0, buf.length() - 1);
            } else
                productName = args[1];

            // getting the highest id from the file
            int maxId=0;
            try (BufferedReader br=new BufferedReader(new FileReader(fileName))){
                while (br.ready()){
                    String currentString=br.readLine();
                    int currentId=Integer.parseInt(currentString.substring(0, 8).trim());
                    if (maxId<currentId){
                        maxId=currentId;
                    }
                }

            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }

            //creating the line to writing in the file
            StringBuilder sb=new StringBuilder();

            sb.append(maxId+1);       //appending the new id
            while (sb.length()<8){
                sb.append(" ");     //adding require symbols
            }
            sb.append(productName);     //appending productName
            while (sb.length()<38){
                sb.append(" ");     //adding require symbols
            }
            sb.append(price);     //appending price
            while (sb.length()<46){
                sb.append(" ");     //adding require symbols
            }
            sb.append(quantity);     //appending quantity
            while (sb.length()<50){
                sb.append(" ");     //adding require symbols
            }

            String newLineToWrite=sb.toString();

            //writing line into the file
            try (BufferedWriter bw=new BufferedWriter(new FileWriter(fileName, true))){

                bw.write("\n"+newLineToWrite);
            }catch (IOException e){
                e.printStackTrace();
            }
            System.out.println("The job is done!");
        }
    }

}
