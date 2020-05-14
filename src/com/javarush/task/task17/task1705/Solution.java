package com.javarush.task.task17.task1705;

import java.util.ArrayList;
import java.util.List;

/*
Сад-огород
*/
/*
1. Создай метод public void addFruit(int index, String fruit) - который добавляет параметр fruit в лист fruits на позицию index.
2. Создай метод public void removeFruit(int index) - который удаляет из fruits элемент с индексом index.
3. Создай метод public void addVegetable(int index, String vegetable) - который добавляет параметр vegetable в лист vegetables на позицию index.
4. Создай метод public void removeVegetable(int index) - который удаляет из vegetables элемент с индексом index.
5. Класс Garden будет использоваться нитями. Поэтому сделай так, чтобы все методы блокировали мьютекс this.
6. Реализуй это минимальным количеством кода.

Требования:
Класс Garden должен содержать метод public void addFruit(int index, String fruit).
Класс Garden должен содержать метод public void removeFruit(int index).
Класс Garden должен содержать метод public void addVegetable(int index, String vegetable).
Класс Garden должен содержать метод public void removeVegetable(int index).
Метод addFruit(int index, String fruit) должен добавлять параметр fruit в лист fruits на позицию index.
Метод removeFruit(int index) должен удалять из fruits элемент с индексом index.
Метод addVegetable(int index, String vegetable) должен добавлять параметр vegetable в лист vegetables на позицию index.
Метод removeVegetable(int index) должен удалять из vegetables элемент с индексом index.
Все методы класса Garden должны блокировать мьютекс this (быть синхронизированы).
 */
public class Solution {


    public static void main(String[] args) {

    }
    Object fruit = new Object();
    Object vegetable = new Object();

    public static class Garden {

        public final List<String> fruits = new ArrayList<String>();
        public final List<String> vegetables = new ArrayList<String>();

        public synchronized void addFruit(int index, String fruit){
            fruits.add(index, fruit);
        }
        public synchronized void addVegetable(int index, String vegetable){
            vegetables.add(index, vegetable);
        }
        public synchronized void removeFruit(int index){
            fruits.remove(index);
        }
        public synchronized void removeVegetable(int index){
            vegetables.remove(index);
        }
    }

}
