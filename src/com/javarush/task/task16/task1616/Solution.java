package com.javarush.task.task16.task1616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Считаем секунды
*/
/*
1. Напиши реализацию метода run в нити Stopwatch (секундомер).
2. Stopwatch должен посчитать количество секунд, которое прошло от создания нити до ввода строки.
3. Выведи количество секунд в консоль.

Требования:
Метод run класса Stopwatch (секундомер) должен содержать цикл.
Метод run должен вызывать Thread.sleep(1000).
Метод run должен увеличивать значение поля seconds на 1 каждую секунду.
После прерывания работы нити Stopwatch (вызова метода interrupt), метод run должен вывести количество секунд (seconds) в консоль.
В классе Stopwatch должен быть только один метод run.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
        System.out.println("я ещё работаю!");
    }

    public static class Stopwatch extends Thread {
        private int seconds;

        public void run() {

                try {
                    while(!isInterrupted()){
                    //add your code here - добавьте код тут
                    Thread.sleep(1000);
                    seconds++;
                    }
                } catch (InterruptedException e) {
                    System.out.println(seconds);
                }


        }
    }
}
