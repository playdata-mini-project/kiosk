package controller;

import service.ManagerService;

import java.util.Scanner;

public class ManagerController {

    private final ManagerService managerService = ManagerService.getInstance();
    public void selectMode(){

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1. 재고관리 2. 주문내역확인 3. 수량추가");
            int mode = sc.nextInt();
            if(mode==1){
                stockCheck(sc);
            }
            if(mode==2){
                orderCheck(sc);
            }
            if(mode==3){
                plusQuantity(sc);
            }
        }
    }

    private void stockCheck(Scanner sc) {
        System.out.println("재고 목록을 확인합니다.");
        managerService.stockCheck();
    }

    private void orderCheck(Scanner sc) {
        System.out.println("주문 내역을 확인합니다.");
        managerService.orderCheck();
    }
    public void plusQuantity(Scanner sc) {
        System.out.println("상품 아이디를 고르세요");
        int productId = sc.nextInt();
        System.out.println("수량을 입력하세요");
        int quantity = sc.nextInt();
        managerService.plusQuantity(productId, quantity);
    }

}
