package com.javarush.task.task13.task1312;
/*
Код сам не исправится
*/
/*
Исправить код так, чтобы программа выполнялась и выводила "Я переводчик с английского".
Метод main менять нельзя!

Требования:
Программа должна выводить на экран фразу - "Я переводчик с английского".
Метод translate должен возвращать строку - "Я переводчик с английского".
Программа должна выполняться без ошибок.
Метод main должен выводить на экран результат вызова метода translate у объекта типа Translator.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        Translator  translator = new TranslatorEN();
        System.out.println(translator.translate());
    }

    public abstract static class Translator {
        public abstract String translate();
    }
    public static class TranslatorEN extends Translator {
        @Override
        public String translate() {
            return "Я переводчик с английского";
        }
    }

}
