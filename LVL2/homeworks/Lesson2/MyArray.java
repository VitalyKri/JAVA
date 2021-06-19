package Lesson2;


class MyArraySizeException extends Exception {

    public MyArraySizeException(String mgs) {
        super(mgs);
    }

}

class MyArrayDataException extends Exception {


    public MyArrayDataException(String msg) {
        super(msg);
    }

}


public class MyArray {

    public static int sumArray(String[][] array) throws MyArrayDataException, MyArraySizeException {

        if (array.length != 4)
            throw new MyArraySizeException("У массива количество строк (" + array.length + ") не равна 4");
        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4)
                throw new MyArraySizeException("У массива количество столбцов (" + array[i].length + ") в строке (" +
                        (i + 1) + ") не равна 4");
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                // Я должен существующую ошибку отлавливать? или проверять входные данные и возвращать исключение в случае ошибки?
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке [" + i + "][" + j + "] находиться значение (" +
                            array[i][j] + "), а не число");
                }


            }
        }


        return sum;
    }

    public static void main(String[] args) {

        String[][] arrayString1 = {{"1", "2", "3", "4"},
                //{"1", "2", "3", "4"},
                {"1", "2", "3", "f"},
                {"1", "2", "3", "4"}};
        String[][] arrayString2 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4","2312"},
                {"1", "2", "3", "3"},
                {"1", "2", "3", "4"}};
        String[][] arrayString3 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "f"},
                {"1", "2", "3", "4"}};
        String[][] arrayString4 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "1"},
                {"1", "2", "3", "4"}};
        int sum;
        String[][][] layersCube = {arrayString1,arrayString2,arrayString3,arrayString4};
        for (int i = 0; i < 4; i++) {
            try {
                sum = sumArray(layersCube[i]);
                System.out.println("Сумма массива = "+sum );
            } catch (MyArrayDataException e) {
                e.printStackTrace();
            } catch (MyArraySizeException e) {
                e.printStackTrace();
            }
        }





    }

}
