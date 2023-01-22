package sem1_hw;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ex_1();
        ex_2();
        ex_3();
    }

    /*  1. Задать одномерный массив и найти в нем минимальный и максимальный элементы */
    private static void ex_1() {
        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        System.out.println(Arrays.toString(array));

        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;

        for (int item : array) {
            maxNumber = Math.max(item, maxNumber);
            minNumber = Math.min(item, minNumber);
        }

        System.out.println("Min number: " + minNumber);
        System.out.println("Max number: " + maxNumber);
    }




    /* 2. Написать метод, который определяет, является ли год високосным, и возвращает boolean
           (високосный - true, не високосный - false). Каждый 4-й год является високосным,
           кроме каждого 100-го, при этом каждый 400-й – високосный. */
    private static void ex_2() {
        Scanner yearScanner = new Scanner(System.in);
        System.out.print("Введите год: ");
        int year = Integer.parseInt(yearScanner.nextLine());
        System.out.println(isLeapYear(year) ? "Високосный год" : "Не високосный год");
        yearScanner.close();
    }
    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }


    /* 3. Дан массив nums = [3,2,2,3] и число val = 3.
     Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
     Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного,
     а остальные - равны ему. */
    private static void ex_3() {
        int val = 3;
        int[] arr = new int[10];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(5);
        }
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(arr));

        int lIndex = 0;
        int rIndex = arr.length - 1;
        while (lIndex <= rIndex) {
            if (arr[lIndex] == val && arr[rIndex] != val) {
                arr[lIndex] = arr[rIndex];
                arr[rIndex] = val;
                lIndex++;
                rIndex--;
            } else {
                if (arr[lIndex] != val) {
                    lIndex++;
                }
                if (arr[rIndex] == val) {
                    rIndex--;
                }
            }
        }

        System.out.print("Изменённый массив: ");
        System.out.println(Arrays.toString(arr));
    }
}



