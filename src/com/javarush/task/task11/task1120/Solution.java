package com.javarush.task.task11.task1120;
/*
Пятая правильная «цепочка наследования»
*/
/*
Расставь правильно "цепочку наследования" в классах: House (дом), Cat (кот), Dog (собака), Car (машина), Animal (животное), Asset (имущество).

Требования:
Правильно унаследуй класс House.
Правильно унаследуй класс Cat.
Правильно унаследуй класс Dog.
Правильно унаследуй класс Car.
Правильно унаследуй класс Animal.
Правильно унаследуй класс Asset.
 */
public class Solution {
    public static void main(String[] args) {
    }

    public class House extends Assets {

    }

    public class Cat  extends Animal{

    }

    public class Car extends Assets {

    }

    public class Dog extends Animal {

    }

    public class Animal {

    }

    public class Assets {

    }
}
