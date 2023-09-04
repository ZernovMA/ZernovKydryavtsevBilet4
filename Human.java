import java.util.ArrayList;
import java.util.List;

class Human {
    private static int totalHumans = 0;  // количество всех людей
    private String name;
    private String gender;
    private int age;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, String gender, int age, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();

        if (father != null && father.getAge() < age) {
            throw new IllegalArgumentException("Возраст отца не может быть меньше возраста ребенка.");
        }

        if (mother != null && mother.getAge() < age) {
            throw new IllegalArgumentException("Возраст матери не может быть меньше возраста ребенка");
        }

        if (father != null) {
            father.addChild(this);
        }

        if (mother != null) {
            mother.addChild(this);
        }

        totalHumans++;
    }

    public static int getTotalHumans() {
        return totalHumans;
    }

    public void incrementAge() {
        age++;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ").append(name);
        sb.append("\nПол: ").append(gender);
        sb.append("\nВозраст: ").append(age);

        if (father != null) {
            sb.append("\nОтец: ").append(father.getName());
        }

        if (mother != null) {
            sb.append("\nМать: ").append(mother.getName());
        }

        if (!children.isEmpty()) {
            sb.append("\nДети:");
            for (Human child : children) {
                sb.append("\n- ").append(child.getName());
            }
        }

        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}


