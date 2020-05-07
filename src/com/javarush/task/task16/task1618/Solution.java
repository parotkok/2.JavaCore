package com.javarush.task.task16.task1618;
/*
Снова interrupt
*/
/*
Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().

Требования:
Класс TestThread должен быть унаследован от Thread.
Класс TestThread должен иметь public void метод run.
Метод main должен создавать объект типа TestThread.
Метод main должен вызывать метод start у объекта типа TestThread.
Метод main должен вызывать метод interrupt у объекта типа TestThread.
 */
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        Thread nit = new TestThread();
        nit.start();
        Thread.sleep(2000);
        nit.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{
        public void run(){
            while (true){
                    System.out.println("The second tread runs");
                if(isInterrupted()){
                    System.out.println("the tread is interrupted");
                    break;
                }
            }


        }
    }
}
