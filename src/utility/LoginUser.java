package utility;

import service.UserService;

public class LoginUser {
    private static int id;
    private static String name;
    private static String role;
    private static boolean isLogin = false;

    public static int getId() {
        return id;
    }

    public static String getName() {
        return name;
    }

    public static String getRole() {
        return role;
    }
    public static boolean getIsLogin() {
        return isLogin;
    }



    public static void doLogin(int id, String name, String role){
        LoginUser.id = id;
        LoginUser.name = name;
        LoginUser.role = role;
        LoginUser.isLogin = true;
    }
    public static String printLoginUser() {
        return (LoginUser.id+"번쨰 회원 "+LoginUser.name+"님 ["+LoginUser.role+"]");
    }
}
