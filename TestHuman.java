import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestHuman {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Выберите действие:");
            System.out.println("1 - Создать человека");
            System.out.println("2 - Увеличить возраст на 1");
            System.out.println("3 - Вывести информацию о всех людях");
            System.out.println("4 - Вывести количество существующих людей");
            System.out.println("0 - Выйти");
            System.out.print("Ваш выбор: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createHuman(scanner, humans);
                    break;
                case 2:
                    incrementAge(scanner, humans);
                    break;
                case 3:
                    displayAllHumans(humans);
                    break;
                case 4:
                    displayTotalHumans();
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Некорректный выбор; Попробуйте ещё раз.");
                    break;
            }

            System.out.println();
        } while (choice != 0);
    }

    private static void createHuman(Scanner scanner, List<Human> humans) {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("Введите пол:");
        String gender = scanner.nextLine();

        System.out.println("Введите возраст:");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите имя отца (если есть):");
        String fatherName = scanner.nextLine();

        System.out.println("Введите имя матери (если есть):");
        String motherName = scanner.nextLine();

        Human father = findHumanByName(humans, fatherName);
        Human mother = findHumanByName(humans, motherName);

        try {
            Human human = new Human(name, gender, age, father, mother);
            humans.add(human);
            System.out.println("Человек успешно создан.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании человека: " + e.getMessage());
        }
    }

    private static Human findHumanByName(List<Human> humans, String name) {
        for (Human human : humans) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    private static void incrementAge(Scanner scanner, List<Human> humans) {
        System.out.println("Введите имя человека:");
        String name = scanner.nextLine();

        Human human = findHumanByName(humans, name);

        if (human != null) {
            human.incrementAge();
            System.out.println("Возраст увеличен на 1.");
        } else {
            System.out.println("Человек с таким именем не найден.");
        }
    }

    private static void displayAllHumans(List<Human> humans) {
        System.out.println("Информация о всех людях:");

        for (Human human : humans) {
            System.out.println(human.toString());
            System.out.println("--------------------");
        }
    }

    private static void displayTotalHumans() {
        System.out.println("Количество существующих людей: " + Human.getTotalHumans());
    }
}