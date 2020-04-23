package core.basesyntax.model;

public class Person {
    public static int count = 0;
    private String name;
    private int id;

    public Person(String name) {
        this.name = name;
        this.id = ++count;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{"
                + "name='" + name + '\''
                + ", id=" + id
                + '}';
    }
}
