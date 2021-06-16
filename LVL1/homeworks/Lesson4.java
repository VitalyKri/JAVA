package homeworks;

import com.sun.glass.ui.Size;

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    public static char[][] map;
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int realMax, potenMax, numChain, bestX, bestY;

    public static void main(String[] args) {
        System.out.println("Введите размер матрицы");
        SIZE = sc.nextInt();

        System.out.println();
        System.out.println("Длину победного ряда");
        DOTS_TO_WIN = sc.nextInt();
        System.out.println();
        initMap();
        printMap();
        while (true) {
            if (humanTurnFinal() || robotTurnFinal()) break;
        }
        System.out.println("Игра закончена");
    }

    // в методе описал ход и условия завершения игры. В этом же методе происходит анализ хода ИИ
    public static boolean humanTurnFinal() {
        int x, y;

        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;


        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
        printMap();

        if (checkWin(DOT_X, x, y)) {
            System.out.println("Победил человек");
            return true;
        }
        if (isMapFull()) {
            System.out.println("Ничья");
            return true;
        }

        return false;
    }

    public static boolean robotTurnFinal() {

        int[] x={SIZE}, y={SIZE};

        if (!setComboBreakerPoint(x,y)){
            do {
                x[0] = rand.nextInt(SIZE);
                y[0] = rand.nextInt(SIZE);
            } while (!isCellValid(x[0], y[0]));
            map[y[0]][x[0]] = DOT_O;
            System.out.println("Компьютер сходил в точку " + (x[0] + 1) + " " + (y[0] + 1));
        }{

        }
        printMap();

        if (checkWin(DOT_O, x[0], y[0])) {
            System.out.println("Победил робот");
            return true;
        }

        if (isMapFull()) {
            System.out.println("Ничья");
            return true;
        }

        return false;
    }

    public static boolean isCellValid(int x, int y) {
        if (x >= SIZE || x < 0 || y >= SIZE || y < 0) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }

    }

    public static void printMap() {

        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }


    // Здесь описываются показатели для текущей точки.
    // Будет использоваться для подсчета победы и действий робота
    // Если есть возможность создать цепочку победы.
    // Запомнимает точку, у которой максимальный шанс к победе
    // И проверяю, осталась ли она такой при попытки ее устанить.
    public static void checkPoint(char symb, int x, int y) {
        // 0 - горизонталь, 1- вертикаль, 2- основ диаг, 3- побоч диаг
        int[] realSum = {0,0,0,0};
        int[] potenSum = {0,0,0,0};
        int realMaxNew = 0, numChainNew = 0,potenMaxNew = 0,bestXNew= SIZE,bestYNew= SIZE;
        for (int i = 0; i < SIZE; i++) {
            // проверка горизонали
            if (map[y][i] == symb || map[y][i] == DOT_EMPTY) {
                potenSum[0]++;

                if (map[y][i] == symb)
                    realSum[0]++;
            } else {
                potenSum[0] = 0;
                realSum[0] = 0;
            }

            // проверка вертикали
            if (map[i][x] == symb || map[i][x] == DOT_EMPTY) {
                potenSum[1]++;
                if (map[i][x] == symb)
                    realSum[1]++;
            } else {
                potenSum[1] = 0;
                realSum[1] = 0;
            }

            // проверка основной диагонали
            if (y - (x - i) >= 0 && y - (x - i) < SIZE) { // Если уходит за матрицу первая точка не считаю
                if (map[y - (x - i)][i] == symb || map[y - (x - i)][i] == DOT_EMPTY) {
                    potenSum[2]++;
                    if (map[y - (x - i)][i] == symb) realSum[2]++;
                } else {
                    potenSum[2] = 0;
                    realSum[2] = 0;
                }
            }

            // проверка побочной диагонали
            if (y - (i - x) < SIZE && y - (i - x) >= 0) { // Если уходит за матрицу первая точка не считаю
                if (map[y - (i - x)][i] == symb || map[y - (i - x)][i] == DOT_EMPTY) {
                    potenSum[3]++;
                    if (map[y - (i - x)][i] == symb) realSum[3]++;
                } else {
                    potenSum[3] = 0;
                    realSum[3] = 0;
                }
            }
            // здесь запоминаю лучшую точку
            for (int j = 0; j < 4; j++) {
                if ((potenSum[j] >= DOTS_TO_WIN) || realSum[j]>realMax) {

                    potenMaxNew = potenSum[j];
                    if (realMaxNew < realSum[j]) {
                        realMaxNew = realSum[j];
                        numChainNew = j;
                    }
                }


            }
        }
        // проверка, если это точка поступает на вход снова
        if (bestY == y && bestX == x && realMaxNew < realMax) {
            realMax = realMaxNew;
            if (symb == 'X'){
                bestX = x;
                bestY = y;
                numChain = numChainNew;
            }

        } else if (realMaxNew >= realMax) {
            realMax = realMaxNew;

            if (symb == 'X'){
                potenMax = potenMaxNew;
                bestX = x;
                bestY = y;
                numChain = numChainNew;
            }
        }


    }

    // проверку победы проверяю, через прохождение через поставленную точку (смотря в нее)
    public static boolean checkWin(char symb, int x, int y) {

        checkPoint(symb, x, y);
        if (realMax >= DOTS_TO_WIN) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    // проверяю все точки для лучший полосы лучшей точки, подставля в нее свой символ
    // Передаю массивы что бы заполнить значение точек
    public static boolean setComboBreakerPoint(int[] newBestXArr,int[] newBestYArr) {
        int oldRealMax = realMax, delta = SIZE;
        int newBestX = newBestXArr[0],newBestY =newBestYArr[0];
        boolean foundBestPoint = false;
        for (int i = 0; i < SIZE; i++) {
            switch (numChain) {
                // горизональ
                case 0: {
                    if (map[bestY][i] != '•') {
                        break;
                    }
                    map[bestY][i] = 'O';
                    checkPoint('X', bestX, bestY);

                    if (Math.abs(bestY - i) < delta || oldRealMax > realMax) {
                        if (Math.abs(bestY - i) < delta) {
                            delta = Math.abs(bestY - i);
                        }
                        newBestX = i;
                        newBestY = bestY;
                    }
                    map[bestY][i] = '•';


                    break;
                }
                // вертикаль
                case 1: {
                    if (map[i][bestX] != '•') {
                        break;
                    }
                    map[i][bestX] = 'O';

                    checkPoint('X', bestX, bestY);
                    if (Math.abs(bestY - i) < delta || oldRealMax > realMax) {
                        if (Math.abs(bestY - i) < delta) {
                            delta = Math.abs(bestY - i);
                        }
                        newBestX = bestX;
                        newBestY = i;
                    }
                    map[i][bestX] = '•';

                    break;
                }
                //основ диаг
                case 2: {
                    if (!(bestY - (bestX - i) >= 0 && bestY - (bestX - i) < SIZE) || map[bestY - (bestX - i)][i] != '•') {
                        break;
                    }

                    map[bestY - (bestX - i)][i] = 'O';

                    checkPoint('X', bestX, bestY);
                    if (Math.abs(bestY - i) < delta || oldRealMax > realMax) {
                        if (Math.abs(bestY - i) < delta) {
                            delta = Math.abs(bestY - i);
                        }
                        newBestX = i;
                        newBestY = bestY - (bestX - i);
                    }
                    map[bestY - (bestX - i)][i] = '•';
                    break;
                }

                //побоч диаг
                case 3:
                    if (!(bestY - (i - bestX) >= 0 && bestY - (i - bestX) < SIZE)||map[bestY - (i - bestX)][i]!= '•') {
                        break;
                    }
                    map[bestY - (i - bestX)][i] = 'O';
                    checkPoint('X', bestX, bestY);
                    if (Math.abs(bestY - i) < delta || oldRealMax > realMax) {
                        if (Math.abs(bestY - i) < delta) {
                            delta = Math.abs(bestY - i);
                        }
                        newBestX = i;
                        newBestY = bestY - (i - bestX);
                    }
                    map[bestY - (i - bestX)][i] = '•';
                    break;
            }
        }

        if (newBestX<SIZE) {
            map[newBestY][newBestX] = 'O';
            newBestXArr[0] = newBestX;
            newBestYArr[0] = newBestY;
            checkPoint('X', bestX, bestY);
            System.out.println("Компьютер сходил в точку " + (newBestX + 1) + " " + (newBestY + 1));
            return true;
        }
        return false;

    }

}

