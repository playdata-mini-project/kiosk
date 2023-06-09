package service;

import domain.dto.LoginDto;
import domain.dto.SignupDto;
import repository.UserRepository;

public class UserService {

    private static UserService service;

    // 싱글톤
    public static UserService getInstance() {
        if (service == null) {
            service = new UserService();
        }
        return service;
    }


    public boolean login(LoginDto dto) {
        return new UserRepository().login(dto);
    }

    public void signup(SignupDto dto) {
        new UserRepository().insertUser(dto);
    }
}
