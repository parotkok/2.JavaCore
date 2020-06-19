package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/*
Закрепляем адаптер

Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.

Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada

Требования:
Класс Solution должен содержать public static поле countries типа Map<String, String>.
В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
Класс Solution должен содержать интерфейс RowItem.
Класс Solution должен содержать интерфейс Contact.
Класс Solution должен содержать интерфейс Customer.
Класс DataAdapter должен реализовывать интерфейс RowItem.
Класс DataAdapter должен содержать два приватных поля: customer типа Customer и contact Contact.
Класс DataAdapter должен содержать конструктор с параметрами (Customer customer, Contact contact), который инициализирует поля contact и customer.
В классе DataAdapter реализуй методы интерфейса RowItem используя подсказки в виде комментариев в интерфейсах.
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

    public static class DataAdapter implements RowItem {
        private Contact contact;
        private Customer customer;
        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }
        @Override
        public String getCompany() {
            return this.customer.getCompanyName();
        }
        @Override
        public String getContactFirstName() {
            String[] str = this.contact.getName().split(", ");
            return str[1];
        }
        @Override
        public String getContactLastName() {
            String[] str = this.contact.getName().split(", ");
            return str[0];
        }
        @Override
        public String getCountryCode() {
            String res=null;
            for (Map.Entry<String,String> pair :countries.entrySet()) {
                if (pair.getValue().equals(customer.getCountryName())) {
                    res = pair.getKey();
                    break;
                }
            }
            return res;
        }
        @Override
        public String getDialString() {
            String tel = "callto://" + contact.getPhoneNumber().replaceAll("[()-]","");
            return tel;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}
