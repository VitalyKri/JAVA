package homeworks.LVL2.Lesson1.Barrier;

import homeworks.LVL2.Lesson1.Runner.Competitor;

public class Water extends Obstacle {
    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length);
    }
}
