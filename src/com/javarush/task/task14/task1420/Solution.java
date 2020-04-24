package com.javarush.task.task14.task1420;

import java.util.Scanner;

/*
НОД
*/
/*
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.

Требования:
Программа должна считывать с клавиатуры 2 строки.
В случае если введенные строки невозможно преобразовать в положительные целые числа, должно возникать исключение.
Программа должна выводить данные на экран.
Программа должна выводить на экран наибольший общий делитель(НОД) чисел считанных с клавиатуры и успешно завершаться.
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a <= 0 || b <= 0) throw new Exception();

        int max = Math.max(a, b);
        for (int i = max; i>0; i--){
            if (a % i == 0  && b % i == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
