package homeworks;

public class Lesson2 {
    public static void main(String[] args) {
        System.out.println(sumDouble(12, 3));
        positiveNegative(10);
        positiveNegative(-10);
        System.out.println(getPositiveNegative(-10));
        printCount("Ура!",4);
        System.out.println(leapYear(1900));
    }

    public static boolean sumDouble(int a, int b) {

        if (a + b <= 20 && a + b >= 10) {
            return true;
        } else {
            return false;
        }

    }

    public static void positiveNegative(int number) {
        if (number >= 0) {
            System.out.println("Это положительное");
        } else {
            System.out.println("Это отрицательное");
        }
    }

    public static boolean getPositiveNegative(int number) {
        if (number >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printCount(String word, int count) {
        int i = 0;
        while (i < count) {
            System.out.println(word);
            i++;
        }

    }

    public static boolean leapYear(int year) {
        boolean leapYear = false;
        if (year % 4 == 0) {
            leapYear = true;
        }
        if (year % 100 == 0) {
            leapYear = false;
        }
        if (year % 400 == 0) {
            leapYear = true;
        }
        return leapYear;
    }

}
