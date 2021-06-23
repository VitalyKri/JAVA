package Lesson2;

public enum Fruit {
    ORANGE("Апельсин",3),
    APPLE("Яблоко",2),
    BANANA("Банан",3),
    CHERRY("Вишня",4);

    private String rus;
    private int weight;

    Fruit(String rus, int weight) {
        this.rus = rus;
        this.weight = weight;
    }

    public String getRus() {
        return rus;
    }

    public int getWeight() {
        return weight;
    }
}
class MainFruit {
    public static void main(String[] args) {
        Fruit f = Fruit.ORANGE;
        if (Fruit.ORANGE == Fruit.APPLE){

        }
        for (Fruit ff :
                Fruit.values()) {
            System.out.println(ff + " "+ ff.getRus() + " "+ ff.getWeight()
            + " " + ff.ordinal());
        }


    }
}
