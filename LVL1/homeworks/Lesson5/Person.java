package homeworks.Lesson5;

public class Person {
    private String fio;
    private String post;
    private String email;
    private String telephone;
    private double salary;
    private int age;

    public Person(String fio, String post, String email, String telephone, double salary, int age) {
        this.fio = fio;
        this.post = post;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void info() {
        System.out.println("Сотрудник:"+this.fio);
        System.out.println("Имеет должность:"+this.post);
        System.out.println("Имеет email:"+this.email);
        System.out.println("Имеет телефон:"+this.telephone);
        System.out.println("Имеет зарплату:"+this.salary);
        System.out.println("Имеет возраст:"+this.age);
    }

}
