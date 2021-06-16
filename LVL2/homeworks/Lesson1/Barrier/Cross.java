package homeworks.LVL2.Lesson1.Barrier;

import homeworks.LVL2.Lesson1.Runner.Competitor;

public class Cross extends Obstacle {
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}
