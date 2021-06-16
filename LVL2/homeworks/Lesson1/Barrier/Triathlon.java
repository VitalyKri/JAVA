package homeworks.LVL2.Lesson1.Barrier;

import homeworks.LVL2.Lesson1.Runner.Competitor;
import homeworks.LVL2.Lesson1.Runner.Team;

public class Triathlon extends Obstacle {
    String name;
    Obstacle[] obstacles = new Obstacle[4];

    public Triathlon(String name, Obstacle obstacle1, Obstacle obstacle2, Obstacle obstacle3, Obstacle obstacle4) {
        this.obstacles[0] = obstacle1;
        this.obstacles[1] = obstacle2;
        this.obstacles[2] = obstacle3;
        this.obstacles[3] = obstacle4;
        this.name = name;

    }

    // Сделал 2 метода не стал реализовывать здесь фичи принадлежащие к команде.
    // Сделал по заданию, т.к. требовалось создать метод,
    // который будет просить команду пройти всю полосу;

    public void doIt(Team team) {
        team.start(this);
    }

    @Override
    public void doIt(Competitor competitor) {
        for (Obstacle obstacle : obstacles) {

            obstacle.doIt(competitor);
            // Вот тут сомнение, зона ответственности правильно выбрана?
            // Т.к. кажется, что изменение метода isOnDistance(), может повлияет на этот функционал

            if (!competitor.isOnDistance()) break;

        }
    }
}
