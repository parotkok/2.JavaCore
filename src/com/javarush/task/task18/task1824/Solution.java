package com.javarush.task.task18.task1824;

import java.io.*;

/*
Файлы и исключения

Читайте с консоли имена файлов.
Если файла не существует (передано неправильное имя файла), то перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки.
Не используйте System.exit();

Требования:
Программа должна считывать имена файлов с консоли.
Для каждого файла нужно создавать поток для чтения.
Если файл не существует, программа должна перехватывать исключение FileNotFoundException.
После перехвата исключения, программа должна вывести имя файла в консоль и завершить работу.
Потоки для чтения из файла должны быть закрыты.
Команду "System.exit();" использовать нельзя.
*/
public class Solution {
    public static void main(String[] args) {
        String fileName=null;

            try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
                while (true) {
                    fileName = br.readLine();
                    try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

                    } catch (FileNotFoundException e) {
                        System.out.println(fileName);
                        break;
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }

    }
}
