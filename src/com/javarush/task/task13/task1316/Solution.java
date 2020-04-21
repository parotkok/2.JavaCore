package com.javarush.task.task13.task1316;
/*
Некорректные строки
*/
/*
Удали все некорректные строки в интерфейсе Button.

Требования:
Интерфейс SimpleObject должен быть объявлен внутри класса Solution.
Интерфейс Button должен быть объявлен внутри класса Solution.
Метод main менять нельзя.
В интерфейсе Button должно остаться объявление константы NAME.
В интерфейсе Button должно остаться корректное объявление метода onPress.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(SimpleObject.NAME);
        System.out.println(Button.NAME);
    }

    interface SimpleObject {
        String NAME = "SimpleObject";
        void onPress();
    }

    interface Button extends SimpleObject {

        final String NAME = "Submit";

        String onPress(Object o);
    }
}
