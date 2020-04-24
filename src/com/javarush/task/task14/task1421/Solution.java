package com.javarush.task.task14.task1421;
/*
Singleton
*/
/*
Класс является синглтоном (реализует паттерн Singleton), если позволяет создать всего один объект своего типа.

Реализовать Singleton pattern:
1. Создай класс Singleton в отдельном файле.
2. Добавь в него статический метод getInstance().
3. Метод getInstance должен возвращать один и тот же объект класса Singleton при любом вызове метода getInstance.
4. Подумай, каким образом можно запретить создание других объектов этого класса.
5. Сделай все конструкторы в классе Singleton приватными (private).
6. В итоге должна быть возможность создать объект (экземпляр класса) ТОЛЬКО используя метод getInstance.

Требования:
Класс Singleton должен быть создан в отдельном файле.
Класс Singleton не должен позволять создавать объекты своего типа извне класса.
Класс Singleton должен содержать приватное статическое поле instance типа Singleton.
В классе Singleton должен быть реализован публичный статический метод getInstance возвращающий значение поля instance.
Метод getInstance должен ВСЕГДА возвращать один и тот же объект.
 */
public class Solution {
    public static void main(String[] args) {
        Singleton one = Singleton.getInstance();
        Singleton two = Singleton.getInstance();
        System.out.println(one);
        System.out.println(two);
    }

}
