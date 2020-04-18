package com.javarush.task.task12.task1216;
/* Интерфейс Fly
Напиши свой public интерфейс Fly(летать). Добавь в него два метода.
*/
/*
Напиши свой public интерфейс CanFly(летать).
Добавь в него два метода.

Требования:
Класс Solution должен содержать интерфейс CanFly.
Интерфейс CanFly должен быть публичным.
Интерфейс CanFly должен содержать два метода.
Интерфейс CanFly не должен иметь родителя.
 */
public class Solution {
    public interface CanFly{
        void fly();
        void fall();
    }

    public static void main(String[] args) {

    }
}
