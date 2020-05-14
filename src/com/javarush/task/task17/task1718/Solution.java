package com.javarush.task.task17.task1718;
/*
Глажка
*/
/*
И снова быт...
Поставьте один synchronized, чтобы diana и igor гладили по очереди, ведь утюг всего один!

Подсказка:
использовать блокировку на уровне класса.

Требования:
Класс Solution должен содержать public static класс Clothes.
Класс Solution должен содержать public static класс Iron.
Класс Solution должен содержать public static класс Person.
Класс Person должен быть нитью.
В методе run() класса Person должен быть synchronized блок.
Synchronized блок должен использовать блокировку на уровне класса.
 */
public class Solution {
    public static void main(String[] args) {
        Person diana = new Person("Diana");
        Person igor = new Person("Igor");
        diana.start();
        igor.start();
    }

    public static class Person extends Thread { //Человек

        public Person(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (Iron.class){
                Iron iron = takeIron();
                Clothes clothes = takeClothes();
                iron(iron, clothes);
                returnIron();
            }

        }

        protected Iron takeIron() {
            System.out.println("Taking the iron");
            return new Iron();
        }

        protected Iron returnIron() {
            System.out.println("Returning the iron");
            return new Iron();
        }

        protected Clothes takeClothes() {
            return new Clothes("T-shirt");
        }

        protected void iron(Iron iron, Clothes clothes) {
            System.out.println(getName() + " is ironing a " + clothes.name);
        }
    }

    public static class Iron {
        private Iron iron;

        private Iron(){
        }

        public Iron getIronInstance(){
            if(iron == null) iron = new Iron();
            return iron;
        }
    } //Утюг

    public static class Clothes {//Одежда
        String name;

        public Clothes(String name) {
            this.name = name;
        }
    }
}
