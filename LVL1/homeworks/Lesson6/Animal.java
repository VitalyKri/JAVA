package homeworks.Lesson6;

abstract class Animal {
    protected String name;
    private static int countAnimal = 0;
    protected int maxRun;
    protected int maxSwim;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
        countAnimal =countAnimal +1;
    }

    public static void getCountAnimal() {
        System.out.println("Всего животных "+countAnimal);
    }

    abstract void run(int lenght);

    abstract void swim(int lenght);

}



