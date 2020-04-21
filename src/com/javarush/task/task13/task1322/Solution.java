package com.javarush.task.task13.task1322;
/*
Интерфейс SimpleObject
*/
/*
1. Создай класс StringObject.
2. В классе StringObject реализуй интерфейс SimpleObject с параметром типа String.
3. Программа должна компилироваться.

Требования:
Класс StringObject должен реализовывать интерфейс SimpleObject.
Интерфейс SimpleObject в классе StringObject должен быть реализован с параметром типа String.
В классе StringObject реализовать метод getInstance интерфейса SimpleObject.
Класс StringObject должен существовать в классе Solution.
Класс StringObject должен быть статическим.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        SimpleObject<String> stringObject = new StringObject<String>();
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    public static class StringObject<T>  implements SimpleObject<String>{

        @Override
        public SimpleObject<String> getInstance() {
            return this;
        }
    }
}
