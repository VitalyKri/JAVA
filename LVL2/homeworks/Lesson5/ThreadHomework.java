package Lesson5;

import java.util.ArrayList;
import java.util.List;

public class ThreadHomework {
    public static void main(String[] args) {
        firstMethod();
        secondMethod(16);
    }

    public static void firstMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    //
    public static void secondMethod(int countThread) {
        int size = 10_000_000, balanceSize = size;


        float[] initialArray = new float[size];
        float[] mergeArray = new float[size];
        for (int i = 0; i < initialArray.length; i++) {
            initialArray[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        List<float[]> pieceList = new ArrayList<>(countThread);
        Thread[] threads = new Thread[countThread];

        for (int i = 0; i < countThread; i++) {
            // Если будет остаток от деления 100/3 например, на последний элемент все оставшиеся списываю
            int arraySize = size / countThread * 1.5 > balanceSize ? balanceSize : size / countThread;
            // массив источник, позиция элемента источника, массив приемник, позиция массива приемника, длина;
            float[] arrayThread = new float[arraySize];
            System.arraycopy(initialArray, size - balanceSize, arrayThread, 0, arraySize);
            int counter = size - balanceSize;
            balanceSize -= arraySize;
            pieceList.add(arrayThread);


            threads[i] = new Thread(() -> {
                for (int j = 0; j < arrayThread.length; j++) {
                    arrayThread[j] = (float) (arrayThread[j] * Math.sin(0.2f + (j + counter) / 5) * Math.cos(0.2f + (j + counter) / 5) * Math.cos(0.4f + (j + counter) / 2));
                }
            });
            threads[i].start();


        }
        for (int i = 0; i < pieceList.size(); i++) {
            try {
                threads[i].join();
                float[] array = pieceList.get(i);

                System.arraycopy(array, 0, mergeArray, balanceSize, array.length);
                balanceSize += array.length;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");


    }
}