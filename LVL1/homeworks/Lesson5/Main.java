package homeworks.Lesson5;

public class Main {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Соловьев В.А","Ведущий разработчик",
                "example@mail.com","89999999999",1000,25);
        persArray[1] = new Person("Сидоров В.А","Главный разработчик",
                "example@mail.com","89999999999",1000,25);
        persArray[2] = new Person("Звягенцев В.А","Разработчик",
                "example@mail.com","89999999999",1000,60);
        persArray[3] = new Person("Журавлев В.А","Ген.дир.",
                "example@mail.com","89999999999",1000,100);
        persArray[4] = new Person("Орлов В.А","Бизнес-аналик",
                "example@mail.com","89999999999",1000,50);
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40){
                persArray[i].info();
            }
        }
    }

}
