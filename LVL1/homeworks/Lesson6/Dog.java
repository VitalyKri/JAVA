package homeworks.Lesson6;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        this.maxRun = 500;
        this.maxSwim = 15;

    }

    @Override
    public void run(int lenght) {
        if ( lenght <0  ) {
            System.out.println("Введено не правильно число");
            return;
        }
        if (maxRun < lenght) {
            System.out.println(name + " не может бежать " + lenght + ". Он может пробежать только " + maxRun + " м.");
        } else {
            System.out.println(name + " пробежал " + lenght + " м.");
        }


    }

    @Override
    public void swim(int lenght) {
        if ( lenght <0  ) {
            System.out.println("Введено не правильно число");
            return;
        }
        if (maxSwim < lenght) {
            System.out.println(name + " не может плыть " + lenght + ". Он может проплыть только " + maxSwim + " м.");
        } else {
            System.out.println(name + " проплыл " + lenght + " м.");
        }

    }
}
