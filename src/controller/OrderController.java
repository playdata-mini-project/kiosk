package controller;

import service.OrderService;
import service.UserService;

import java.util.Scanner;

public class OrderController {

    private static final OrderService orderService = OrderService.getInstance();

    public void selectMode() {
        order(3, 1,2);
    }
    private void order(int userId,int productId,int quantity){
        orderService.order(userId,productId,quantity);
    }
}
