package controller;

import domain.dto.LoginDto;
import domain.dto.SignupDto;
import domain.entity.Category;
import domain.entity.User;
import service.UserService;
import utility.LoginUser;

import java.util.Scanner;

public class UserController {

    private static final UserService userService = UserService.getInstance();
    private final ManagerController managerController = new ManagerController();
    private final CategoryController categoryController = new CategoryController();

    public void selectMode(){

        Scanner sc = new Scanner(System.in);


        while(true){
            System.out.println("1. 로그인 2. 회원가입");
            String mode = sc.nextLine();
            if(mode.equals("1")){
                login(sc);
                if(LoginUser.getIsLogin()){
                    if(LoginUser.getRole().equals("admin")){
                        managerController.selectMode();
                    } else{
                        categoryController.selectMode();
                    }
                }
                break;
            }
            if(mode.equals("2")){
                signUp(sc);
            }
        }


    }

    private void signUp(Scanner sc) {
        System.out.println("insert id :");
        String id = sc.nextLine();
        System.out.println("insert password  :");
        String password = sc.nextLine();
        System.out.println("insert adminCode :");

        String role = "customer";
        Integer code;
        try {
            code = Integer.valueOf(sc.nextLine());
            if (code == 1234){
                role = "admin";
            }
        } catch (NumberFormatException e) {
            code = 0;
        }

        SignupDto dto = new SignupDto(id,password,role);
        userService.signup(dto);
    }

    private void login(Scanner sc) {
        System.out.println("insert name :");
        String name = sc.nextLine();
        System.out.println("insert password :");
        String password = sc.nextLine();
        LoginDto dto = new LoginDto(name,password);
        userService.login(dto);
    }
}
