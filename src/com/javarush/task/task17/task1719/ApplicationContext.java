package com.javarush.task.task17.task1719;

import java.util.HashMap;
import java.util.Map;
/*
ApplicationContext
ApplicationContext будет доступен множеству нитей.
Сделать так, чтобы данные не терялись: подумай, какое ключевое слово необходимо поставить и где.

Требования:
Класс ApplicationContext должен быть абстрактным.
Класс ApplicationContext должен содержать private поле container типа Map<String, GenericsBean>.
В getByName(String name), если необходимо, используй synchronized.
В removeByName(String name), если необходимо, используй synchronized.
*/
public abstract class ApplicationContext<GenericsBean extends Bean> {
    private Map<String, GenericsBean> container = new HashMap<String, GenericsBean>();
    // Map<Name, some class that implements the Bean interface>


    protected ApplicationContext() {
        parseAllClassesAndInterfaces();
    }

    public synchronized GenericsBean getByName(String name) {
        return container.get(name);
    }

    public synchronized GenericsBean removeByName(String name) {
        return container.remove(name);
    }

    protected abstract void parseAllClassesAndInterfaces();

    public static void main(String[] args) {

    }
}
