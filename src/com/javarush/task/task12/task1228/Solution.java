package com.javarush.task.task12.task1228;
/*
Интерфейсы к классу Human
*/
/*
Добавь как можно больше интерфейсов к классу Human, но чтобы он не стал абстрактным классом.
Добавлять методы в класс Human запрещается.

Требования:
Класс Solution должен содержать интерфейс Worker с методом void workLazy().
Класс Solution должен содержать интерфейс Businessman с методом void workHard().
Класс Solution должен содержать интерфейс Secretary с методом void workLazy().
Класс Solution должен содержать интерфейс Miner с методом void workVeryHard().
Класс Solution должен содержать класс Human с методами: void workHard() и void workLazy().
Класс Human должен реализовывать три интерфейса.
 */
public class Solution {
    public static void main(String[] args) {
        Human human = new Human();
        System.out.println(human);
    }
    public static interface Worker {
        public static void workLazy(){
        }
    }
    public static interface Businessman {
        public static void workHard(){
        }
    }
    public static interface Secretary {
        public static void workLazy(){
        }
    }
    public static interface Miner {
        public static void workVeryHard(){
        }
    }

    public static class Human implements Worker, Businessman, Secretary{
        public void workHard() {
        }
        public void workLazy() {
        }
    }
}
