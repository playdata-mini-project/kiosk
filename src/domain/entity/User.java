package domain.entity;

public class User {
    private int id;
    private String name;
    private String role;
    private String password;

    public User(int id, String name, String role, String password) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return
            "name='" + name + '\'' +
                ", role='" + role + '\''
                ;
    }
}
