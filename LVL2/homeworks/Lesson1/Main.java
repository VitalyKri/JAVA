package Lesson1;

import Lesson1.Barrier.Cross;
import Lesson1.Barrier.Triathlon;
import Lesson1.Barrier.Wall;
import Lesson1.Barrier.Water;
import Lesson1.Runner.*;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Бегуны",new Dog("Жулик"),new Cat("Муся"),new Human("Василий"));
        Triathlon triathlon = new Triathlon("Iron man",new Cross(100),new Wall(4),
                new Water(100),new Wall(3));
        triathlon.doIt(team);
        team.showResults();


    }
}