package utility.cafe;

import domain.entity.Product;
import domain.entity.User;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeMaker extends Thread{
    private static final int SECOND = 1000;
    private static int orderNumber = 0;
    private static Queue<OrderBoard> cafeQueue = new LinkedList<>();

    public static void printCafeQueue(){
        for (OrderBoard orderBoard : cafeQueue) {
            System.out.println(orderBoard);
        }
    }

    public static void addCoffee(User user, Product product){
        System.out.println("음료 제조 시작..");
        OrderBoard order = OrderBoard.createOrder(++orderNumber, user, product);
        cafeQueue.add(order);
        try {
            Thread.sleep(SECOND * product.getMakeTime());
        } catch (InterruptedException e) {
            System.out.println("기계 고장남...");
        }
        order.changeIsComplete();
        System.out.println(orderNumber + "번 음료 제조 완료");
        //cafeQueue.poll();
    }
}
