package homeworks.Lesson6;

import java.util.Random;

public class AnimalsApp {

    public static void main(String[] args) {

        Animal[] animals = {new Dog("Жулик"),new Cat("Муся")} ;
        Cat[] cats = {new Cat("Сенька"),new Cat("Варя")};
        Random random = new Random();
        for (Animal a: animals) {
            a.run(random.nextInt(1000));
            a.swim(random.nextInt(1000));
            System.out.println(a.getClass());
        }
        for (Animal a: cats) {
            a.run(random.nextInt(1000));
            a.swim(random.nextInt(1000));
            System.out.println(a.getClass());
        }
        Animal.getCountAnimal();
    }
}
