package com.javarush.task.task18.task1815;

import java.util.List;

/*
Таблица
Измени класс TableInterfaceWrapper так, чтобы он стал Wrapper-ом для TableInterface.
Метод setModel должен вывести в консоль количество элементов в новом листе перед обновлением модели.
Метод getHeaderText должен возвращать текст в верхнем регистре - используйте метод toUpperCase().

Требования:
Класс TableInterfaceWrapper должен реализовывать интерфейс TableInterface.
Класс TableInterfaceWrapper должен инициализировать в конструкторе поле типа TableInterface.
Метод setModel() должен вывести в консоль количество элементов в новом листе перед обновлением модели.
Метод getHeaderText() должен возвращать текст в верхнем регистре.
Метод setHeaderText() должен устанавливать текст для заголовка без изменений.
*/
public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
        private TableInterface component;

        public TableInterfaceWrapper(TableInterface component) {
            this.component = component;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            this.component.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return  this.component.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            this.component.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}