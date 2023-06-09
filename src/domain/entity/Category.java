package domain.entity;

public class Category {

    int id;
    String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
