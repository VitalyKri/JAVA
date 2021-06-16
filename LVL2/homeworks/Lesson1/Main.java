package homeworks.LVL2.Lesson1;

import homeworks.LVL2.Lesson1.Barrier.Cross;
import homeworks.LVL2.Lesson1.Barrier.Triathlon;
import homeworks.LVL2.Lesson1.Barrier.Wall;
import homeworks.LVL2.Lesson1.Barrier.Water;
import homeworks.LVL2.Lesson1.Runner.*;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Бегуны",new Dog("Жулик"),new Cat("Муся"),new Human("Василий"));
        Triathlon triathlon = new Triathlon("Iron man",new Cross(100),new Wall(4),
                new Water(100),new Wall(3));
        triathlon.doIt(team);
        team.showResults();


    }
}