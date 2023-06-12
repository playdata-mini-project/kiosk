import config.DbInfo;
import controller.UserController;
import utility.InitDb;

public class Main {
    public static void main(String[] args) {
        //new InitDb().initDb();
        new UserController().selectMode();
    }

}


