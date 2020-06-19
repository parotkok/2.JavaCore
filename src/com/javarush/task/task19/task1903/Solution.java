package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;

/*
Адаптация нескольких интерфейсов

Адаптируй IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры).
Обратите внимание на формат вывода фамилии и имени человека.

Требования:
Класс Solution должен содержать public static поле countries типа Map<String, String>.
В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
Класс IncomeDataAdapter должен реализовывать интерфейсы Customer и Contact.
Класс IncomeDataAdapter должен содержать приватное поле data типа IncomeData.
Класс IncomeDataAdapter должен содержать конструктор с параметром IncomeData.
В классе IncomeDataAdapter реализуй методы интерфейсов Customer и Contact используя подсказки в виде комментариев в интерфейсах.

*/
public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;
        IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }
        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }
        @Override
        public String getCountryName() {
            return countries.get(this.data.getCountryCode());
        }
        @Override
        public String getName() {
            return this.data.getContactLastName() + ", " + this.data.getContactFirstName();
        }
        @Override
        public String getPhoneNumber() {
            String phoneNumber = String.format("%010d", data.getPhoneNumber());
            String Part1 = "+" + data.getCountryPhoneCode();
            String Part2 = phoneNumber.substring(0, 3);
            String Part3 = phoneNumber.substring(3, 6);
            String Part4 = phoneNumber.substring(6, 8);
            String Part5 = phoneNumber.substring(8, 10);
            return String.format("%s(%s)%s-%s-%s", Part1, Part2, Part3, Part4, Part5);
        }

    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}
