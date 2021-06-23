package Lesson2;

public class MainEx {
    public static void main(String[] args) {


//        try {
//            int a = 0;
//            int b = 10 / a;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        System.out.println("END!");


        try {
            int[] r = {1, 2, 3};
            int a = 0;
        //    r[20] = 20;
        //    int b = 10 / a;
        }
        catch (ArithmeticException e) {
            System.out.println("Возникло ArithmeticException");
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Возникло Исключение");
        }

        finally {
            System.out.println("Выполниться в любом случае!");
        }

//        try {
//            System.out.println(sqrt(-10));
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        }

    }

    public static int sqrt(int n) {
        if (n > 0) {
            return n / 2;
        }
        throw new ArithmeticException("нельзя отрицательное!");
    }
}
