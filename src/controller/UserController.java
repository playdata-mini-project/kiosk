package controller;

import java.util.Scanner;

public class UserController {

    private static final UserService userService = UserService.getInstance();
    public void selectMode(){

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1. 로그인 2. 회원가입");
            String mode = sc.nextLine();
            if(mode.equals("1")){
                login(sc);
            }
            if(mode.equals("2")){
                signUp(sc);
            }
        }
    }

    private void signUp(Scanner sc) {
        System.out.println("insert NAME : ");
        String name = sc.next();
        System.out.println("insert PASSWORD : ");
        String password = sc.next();
        System.out.println("insert ROLE : ");
        String role = sc.next();

        userService.signUp(new SighUpDto(name, password, role));
    }

    private void login(Scanner sc) {
        System.out.println("insert NAME : ");
        String name = sc.next();
        System.out.println("insert PASSWORD : ");
        String password = sc.next();

        userService.login(new LoginDto(name, password));
    }
}
