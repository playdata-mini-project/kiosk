package controller;

import java.util.Scanner;

public class ManagerController {

    private static final ManagerService managerService = ManagerService.getInstance();
    public void selectMode(){

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1. 재고관리 2. 주문내역확인");
            String mode = sc.nextLine();
            if(mode.equals("1")){
                stockCheck(sc);
            }
            if(mode.equals("2")){
                orderCheck(sc);
            }
        }
    }

    private void stockCheck(Scanner sc) {

        managerService.stockCheck();
    }

    private void orderCheck(Scanner sc) {

        managerService.orderCheck();
    }
}
