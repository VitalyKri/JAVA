package homeworks.Lesson8;

import java.util.Random;
import java.util.Scanner;

public class WordQuest {
    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
            "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    static String wordQuest;

    public static void main(String[] args) {
        wordQuest = words[random.nextInt(words.length - 1)];

        String answer = "", outWord = "";

        do {
            if (!answer.equals("") ) {
                System.out.println(outWord);
                outWord = "";
            }
            System.out.println("Угадайте слово (английская раскладка)");
            answer = sc.next().toLowerCase();
            for (int i = 0; i < 15; i++) {
                if (i < answer.length() && i < wordQuest.length() &&
                        answer.charAt(i) == wordQuest.charAt(i)) {
                    outWord += answer.charAt(i);
                } else outWord += "#";
            }
        } while (!answer.equals(wordQuest));
        System.out.println("Ура вы угадали слово "+ wordQuest);

    }
}
