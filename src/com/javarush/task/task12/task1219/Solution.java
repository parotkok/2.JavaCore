package com.javarush.task.task12.task1219;
/*
Создаем человека
*/
/*
Есть public интерфейсы Fly(летать), Run(бежать/ездить), Swim(плавать).
Добавь эти интерфейсы классам Human(человек), Duck(утка), Penguin(пингвин), Airplane(самолет).
 */
public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        void fly();
    }

    public interface CanRun {
        void run();
    }

    public interface CanSwim {
        void swim();
    }


    public class Human implements CanRun, CanSwim{
        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Duck implements CanSwim, CanRun, CanFly{
        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }

        @Override
        public void fly() {

        }
    }

    public class Penguin implements CanRun, CanSwim{
        @Override
        public void swim() {

        }

        @Override
        public void run() {

        }
    }

    public class Airplane implements CanFly, CanRun{
        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }
    }
}
