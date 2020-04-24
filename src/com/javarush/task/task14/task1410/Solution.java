package com.javarush.task.task14.task1410;
/*
Дегустация вин
*/
/*
1. Создать абстрактный класс Drink с реализованным методом public void taste(), который выводит в консоль "Вкусно".
2. Создать класс Wine, который наследуется от Drink, с реализованным методом public String getHolidayName(), который возвращает строку "День Рождения".
3. Создать класс BubblyWine, который наследуется от Wine, с реализованным методом public String getHolidayName(), который возвращает строку "Новый Год".
4. Написать реализацию методов getDeliciousDrink, getWine, getBubblyWine.
5. Все классы должны находиться в отдельных файлах.

Требования:
Абстрактный класс Drink должен быть создан в отдельном файле.
В классе Drink должен быть реализован метод public void taste(), который выводит на экран строку - "Вкусно".
Класс Wine должен быть создан в отдельном файле и быть потомком класса Drink.
В классе Wine должен быть реализован метод public String getHolidayName(), который возвращает строку - "День Рождения".
Класс BubblyWine должен быть создан в отдельном файле и быть потомком класса Wine.
В классе BubblyWine должен быть реализован метод public String getHolidayName(), который возвращает строку - "Новый Год".
В классе Solution должен быть реализован метод getDeliciousDrink(), который возвращает объект типа Wine.
В классе Solution должен быть реализован метод getWine(), который возвращает объект типа Wine.
В классе Solution должен быть реализован метод getBubblyWine(), который возвращает объект типа BubblyWine.
 */
public class Solution {
    public static void main(String[] args) {
        getDeliciousDrink().taste();
        System.out.println(getWine().getHolidayName());
        System.out.println(getBubblyWine().getHolidayName());
        System.out.println(getWine().getHolidayName());

    }
    public static Drink getDeliciousDrink(){
        return new Wine();
    }
    public static Wine getWine(){
        return new Wine();
    }
    public static Wine getBubblyWine(){
        return new BubblyWine();
    }
}
