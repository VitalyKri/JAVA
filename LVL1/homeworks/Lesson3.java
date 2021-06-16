package homeworks;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {


        tast1();
        tast2();
        tast3();
        tast4();
        tast5(10, 1231);
        tast6();
        int[] a = {2, 2, 2, 1, 2, 12, 10, 11};
        tast7(a);
        a = new int[]{2, 2, 2, 1, 2, 12, 10, 11,123};
        tast8(a, -1);

    }


    public static void tast1() {

        int[] a = new int[15];
        for (int i = 0; i < a.length; i++) {
            if (Math.random() > 0.5) {
                a[i] = 1;
            } else {
                a[i] = 0;
            }

        }

        System.out.println("Задание 1. Было");
        for (int i = 0; i < a.length; i++) {

            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.print(a[i] + " ");
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = (a[i] + 1) % 2;
        }

        System.out.println("Стало");
        for (int i = 0; i < a.length; i++) {

            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void tast2() {

        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {

            a[i] = i;

        }
        System.out.println();
        System.out.println("Задание 2");
        for (int i = 0; i < a.length; i++) {
            if (i % 10 == 0 && i!=0)  {
                System.out.println();
            }
            System.out.print(a[i] + " ");
        }


    }

    public static void tast3() {

        int[] a = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println();
        System.out.println("Задание 3");
        System.out.println("Было");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i]<6) a[i] = a[i]*2;
        }
        System.out.println();
        System.out.println("Стало");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static void tast4() {

        int[][] a = new int[10][10];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (j == i)
                    a[i][j] = 1;
            }

        }
        System.out.println();
        System.out.println("Задание 4");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] tast5(int len, int intinitialValue) {

        int[] a = new int[len];
        for (int i = 0; i < a.length; i++) {
            a[i] = intinitialValue;
        }
        return a;
    }

    public static void tast6() {
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100);
        }

        int min = a[0], max = a[0];

        for (int i = 0; i < a.length; i++) {
            if (min < a[i]) {
                min = a[i];
            }
            if (max > a[i]) {
                max = a[i];
            }
        }
        System.out.println();
        System.out.println("Задание 6");
        System.out.println("Min = " + min + ";Max = " + max + ".  Ниже массив");
        for (int i = 0; i < a.length; i++) {
            if (i % 10 == 0 && i!=0) {
                System.out.println();
            }
            System.out.print(a[i] + " ");
        }
    }

    public static boolean tast7(int[] arr) {
        boolean answer = false;
        int position, left, right = 0;
        // думал сначало сделать вложенный цикл. но рациональнее 2 цикла использовать
        left = Arrays.stream(arr).sum();
        // считаю половинки
        for (position = 0; position < arr.length; position++) {
            left = left - arr[position];
            right = right + arr[position];
            if (left == right) {
                answer = true;
                break;
            }
        }

        System.out.println();
        System.out.println("Задание 7");
        System.out.println(answer);
        // вывод массива
        if (answer) {
            for (int i = 0; i < arr.length; i++) {
                if (i == position && i != 0) {
                    System.out.print(arr[i]+ " = ");
                } else if (i != arr.length-1) {
                    System.out.print(arr[i] + " + ");
                } else {
                    System.out.print(arr[i]);
                }

            }
        }

        return answer;
    }

    public static void tast8(int[] arr,int n) {


        System.out.println();
        System.out.println("Задание 8");
        System.out.println("Было");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


        // Решение
        // определение смещения до 1 круга
        n = n % arr.length;
        // Определяю смещение от 0 до ∞
        if (n<0) {
            n = arr.length + n;
        }
        int newNumber;

        // свигаем массив n количество раз
        for (int i = 0; i < n; i++) {
            newNumber = arr[0];
            for (int j = 0; j < arr.length -1; j++) {
                arr[j] = arr[j+1];
            }
            arr[arr.length-1] =newNumber;
        }
        // Решение


        System.out.println();
        System.out.println("Стало");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void scannerMy() {
        Scanner scanner = new Scanner(System.in);
        int a;
        do {
            System.out.println("Введите число от 5 до 10");
            a = scanner.nextInt();
        }
        while (a > 10 || a < 5);
        System.out.println(a);
        scanner.nextLine();
        String str = scanner.nextLine();
        System.out.println(str);
    }
}
