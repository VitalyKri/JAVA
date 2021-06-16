package homeworks.Lesson7;

public class СatLes7 {
    private String name;
    private int appetite;
    public boolean full;

    public СatLes7(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.full = false;
    }

    public int getAppetite() {
        return appetite;
    }

    public void info() {
        System.out.println("Кошка (" + this.name + ") сыта?" + full);
    }

    public void eat(Plate p) {
        this.full = p.decreaseFood(appetite);

        if ((this.full) || (p.food < this.appetite)){
            return;
        }
        p.decreaseFood(appetite);
        full = true;

    }
}
