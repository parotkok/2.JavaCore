package com.javarush.task.task15.task1501;
/*
ООП - Расставить интерфейсы
*/
/*
1. Добавь все возможные интерфейсы из Movable, Sellable, Discountable в класс Clothes.
2. Реализуй их методы.

Требования:
Класс Clothes должен поддерживать интерфейс Movable.
Класс Clothes должен поддерживать интерфейс Sellable.
Класс Clothes должен поддерживать интерфейс Discountable.
В классе Clothes должен быть реализован метод isMovable.
В классе Clothes должен быть реализован метод getAllowedAction без параметров.
В классе Clothes должен быть реализован метод getAllowedAction с одним параметром типа String.
 */
public class Solution {
    public static void main(String[] args) {

    }

    public interface Movable {
        boolean isMovable();
    }

    public interface Sellable {
        Object getAllowedAction(String name);
    }

    public interface Discountable {
        Object getAllowedAction();
    }

    public static class Clothes implements Movable, Sellable, Discountable {

        @Override
        public boolean isMovable() {
            return true;
        }

        @Override
        public Object getAllowedAction(String name) {
            return null;
        }

        @Override
        public Object getAllowedAction() {
            return null;
        }
    }

}
