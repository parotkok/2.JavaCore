package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Парсер реквестов
*/
/*
Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double: 3.14

Требования:
Программа должна считывать с клавиатуры только одну строку.
Класс Solution не должен содержать статические поля.
Программа должна выводить данные на экран в соответствии с условием.
Программа должна вызывать метод alert с параметром double в случае, если значение параметра obj может быть корректно преобразовано в число типа double.
Программа должна вызывать метод alert с параметром String в случае, если значение параметра obj НЕ может быть корректно преобразовано в число типа double.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        String input;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        input = reader.readLine();
        printParam(paramURL(input));
    }
    public static String[] paramURL(String string){
        return string.substring(string.indexOf('?')+1).split("&");
    }
    public static void printParam(String[] param){
        String obj=null;
        for (String s:param) {
            String par;
            if (s.contains("=")){
                par=s.substring(0,s.indexOf('='));
            }
            else {
                par=s;
            }
            System.out.print(par+" ");

            if (par.equals("obj")){
                obj=s.substring(s.indexOf('=')+1);
            }
        }
        if (obj!=null){
            System.out.print("\n");
            try {
                Double d=Double.parseDouble(obj);
                alert(d);
            }catch (NumberFormatException e){
                alert(obj);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
