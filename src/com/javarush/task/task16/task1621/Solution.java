package com.javarush.task.task16.task1621;
/*
Thread.currentThread - всегда возвращает текущую нить
*/
/*
1. В методе printMsg присвой переменной t текущую нить.
2. В методе printMsg после всех действий поставь задержку в 1 миллисекунду.

Требования:
Метод printMsg должен получать текущую нить с помощью Thread.currentThread.
Метод printMsg должен должен усыплять нить на 1 миллисекунду.
Метод printMsg должен вызывать метод getName у текущей нити.
Метод main должен вызвать метод printMsg у объекта типа ThreadNamePrinter 5 раз.
Метод run должен вызвать метод printMsg 5 раз.
Метод printMsg у объекта типа ThreadNamePrinter суммарно должен быть вызван 10 раз.
 */
public class Solution {
    static int count = 5;

    public static void main(String[] args) {
        NameOfDifferentThreads tt = new NameOfDifferentThreads();
        tt.start();
        for (int i = 0; i < count; i++) {
            tt.printMsg();
        }
    }

    public static class NameOfDifferentThreads extends Thread {
        public void run() {
            for (int i = 0; i < count; i++) {
                printMsg();
            }
        }

        public void printMsg() {
            Thread t = Thread.currentThread();//присвой переменной t текущую нить
            String name = t.getName();
            System.out.println("name=" + name);
            try{
                Thread.sleep(1);}
            catch(InterruptedException e){
                System.out.println(getStackTrace());
            }
            //add sleep here - добавь sleep тут
        }
    }
}
