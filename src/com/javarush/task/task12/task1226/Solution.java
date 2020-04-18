package com.javarush.task.task12.task1226;
/*
Лазать, летать и бегать
*/
/*
1. Внутри класса Solution создай интерфейс public interface CanFly(летать) с методом void fly().
2. Внутри класса Solution создай интерфейс public interface CanClimb(лазить по деревьям) с методом void climb().
3. Внутри класса Solution создай интерфейс public interface CanRun(бегать) с методом void run().
4. Подумай логически, какие именно интерфейсы нужно добавить для каждого класса.
5. Добавь интерфейсы классам Cat(кот), Dog(собака), Tiger(тигр), Duck(Утка).

Требования:
Класс Solution должен содержать интерфейс CanFly с методом void fly().
Класс Solution должен содержать интерфейс CanClimb с методом void climb().
Класс Solution должен содержать интерфейс CanRun с методом void run().
Объект класса Cat должен уметь бегать(поддерживать интерфейс CanRun) и лазить по деревьям(поддерживать интерфейс CanClimb).
Объект класса Dog должен уметь бегать(поддерживать интерфейс CanRun).
Класс Tiger должен быть котом.
Объект класса Duck должен уметь бегать(поддерживать интерфейс CanRun) и летать(поддерживать интерфейс CanFly).
 */
public class Solution {
    public static void main(String[] args) {
    }
    public class Cat implements CanRun, CanClimb {
        @Override
        public void run() {
        }
        @Override
        public void climb() {
        }
    }
    public class Dog implements CanRun{
        @Override
        public void run() {
        }
    }
    public class Tiger extends Cat {
    }
    public class Duck implements CanFly, CanRun{
        @Override
        public void fly() {
        }
        @Override
        public void run() {
        }
    }
    public interface CanFly{
        void fly();
    }
    public interface CanClimb {
        void climb();
    }
    public interface CanRun {
        void run();
    }
}
