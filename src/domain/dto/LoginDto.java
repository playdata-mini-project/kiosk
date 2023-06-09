package domain.dto;

public class LoginDto {
    private String name;
    private String password;

    public LoginDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
