package Lesson3;

import java.util.*;

public class Duplicate {


    public static void main(String[] args) {

        List<String> listWords = new ArrayList<>(30);
        listWords.add("Слово");
        listWords.add("CYЗ");
        listWords.add("Word");
        listWords.add("Wort");
        listWords.add("slovo");
        listWords.add("parole");
        // Первые 6 элементы будут базой
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            listWords.add(listWords.get(random.nextInt(6)));
        }

        Map<String,Integer> equalsWord= new HashMap<>(listWords.size());
        String word;
        for (int i = 0; i < listWords.size(); i++) {
            word = listWords.get(i);
            Integer res = equalsWord.get(word);
            equalsWord.put(word,res ==null ? 1: res+1);
        }
        System.out.println(equalsWord);

    }

}
