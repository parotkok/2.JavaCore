package com.javarush.task.task17.task1720;

public class Bankomat {
    static BankAccount account = new BankAccount("Amigo"); //1. Создается объект

    public static boolean isStopped; //2. volatile boolean isStopped = false

    public static void main(String[] args) throws InterruptedException {
        addMoney.start(); // запускается поток. Метод за 4сек добавит 4 тысячи на счет (если не учитывать время на
        // другие операции) ?
        SpendThread spendThread = new SpendThread(); // создаются объекты
        SpendThread spendThread1 = new SpendThread();
        SpendThread spendThread2 = new SpendThread();
        spendThread.start();  //Запускаются потоки
        spendThread1.start();   // Эти потоки должны поочередно снимать деньги
        spendThread2.start();   //И за 4сек они должны снять 4000 (если не учитывать затраты времени на другие действия)
        Thread.sleep(4000);//через 4сек работы они прерываются
        isStopped = true;
    }

    private static Thread addMoney = new Thread() { //3. Тут создается новый объект addMoney класс Thread ?
        @Override
        public void run() {
            while (!isStopped) { //4. пока isStopped=false пополняем счет на 1000 и делаем задержку на 1сек.
                account.deposit("1000");            //кладем на счет
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    };


    public static class SpendThread extends Thread {

        @Override
        public void run() {
            while (!isStopped) { //5. пока isStopped=false, пробуем снять 100 (если не хватит денег, то вылетит
                //исключение). Дальше задержка 0,1сек.
                try {
                    account.withdraw("100");             //снимаем со счета
                } catch (NotEnoughMoneyException e) {
                    System.out.println("Недостаточно денег");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}


