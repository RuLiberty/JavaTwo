package lesson1.HomeWork;

public class MainClass {
    public static void main(String[] args) {

        Sportsman[] sportsmens = {new Sportsman("Derek", 10.2, 1.5),
                new Sportsman("Mark", 7.1, 0.8),
                new Sportsman("Vasiliy", 4.3, 1.2),
                new Sportsman("Minar", 12.3, 2.2 * Math.random())};

        double barriers[] = {0.4 * Math.random(), 1.2 * Math.random(), 1.1 * Math.random()};

        Course c = new Course(barriers, 5 * Math.random()); // Создаем полосу препятствий
        Team team = new Team("Winners!", sportsmens); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
    }
}
