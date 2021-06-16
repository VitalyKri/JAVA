package homeworks.Lesson7;

public class MainClass {
    public static void main(String[] args) {
        СatLes7[] cats = {new СatLes7("Barsik",5),
                new СatLes7("Сенька",22),new СatLes7("Муся",20),
                new СatLes7("Муся",31),new СatLes7("Муся",20)};
        Plate plate = new Plate(80);
        plate.info();
        for (СatLes7 a: cats) {
            a.eat(plate);
            a.info();
        }
        plate.info();
        plate.additionFood(50);
        plate.info();

    }

}
