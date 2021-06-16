package homeworks.Lesson7;

public class Plate {
    public int food;
    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (n > food) {
            return false;
        }
        food -= n;
        return true;
    }


    public void additionFood(int food) {
        this.food +=food;
    }
    public void info() {
        System.out.println("plate: " + food);
    }

}

