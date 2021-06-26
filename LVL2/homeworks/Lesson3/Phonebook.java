package Lesson3;


import java.util.*;


public class Phonebook{

    private Map<String,Set<String>> listOfPeople = new HashMap<>();

    public void add(String K,String V) {

        Set<String> phones = listOfPeople.get(K);

        if (phones== null) {
            phones = new HashSet<String>(10);
        }
        phones.add(V);

        listOfPeople.put(K,phones);
    }

    public Set<String> get(String K) throws NullPointerException {

        Set<String> phones = listOfPeople.get(K);
        if (phones == null) {
            throw new NullPointerException("У \""+ K+"\" нет телефона");
        }
        return phones;
    }

    public Set<String> get() throws NullPointerException {
        Set<String> people = listOfPeople.keySet();
        if (people == null) {
            throw new NullPointerException("Справочник пустой");
        }

        return people;
    }

    public static void main(String[] args) {
        Phonebook phonebookRussian = new Phonebook();
        phonebookRussian.add("Кукушкин","8(999)999-99-99");
        phonebookRussian.add("Кукушкина","8(999)999-99-19");
        phonebookRussian.add("Кукушкин","8(999)999-99-19");
        phonebookRussian.add("Кукушкина","8(999)999-99-99");
        phonebookRussian.add("Кукушкин","8(999)999-99-99");

        System.out.println("Список людей" +phonebookRussian.get());
        System.out.println("Список телефонов Кукушкина"+phonebookRussian.get("Кукушкин"));
        System.out.println("Список телефонов Кукушкина"+phonebookRussian.get("ава"));
    }


}
