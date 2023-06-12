package service;

import repository.OrderRepository;

import java.util.List;

public class OrderService {

    private static OrderService service;

    private final OrderRepository orderRepository = new OrderRepository();

    // 싱글톤
    public static OrderService getInstance() {
        if (service == null) {
            service = new OrderService();
        }
        return service;
    }
    public void order(int userId, int productId, int quantity)  {
        // 재고수량 확인
        int stock = orderRepository.getStock(productId);
        System.out.println("상품번호 : " + productId + " 주문수량 :" + quantity);
        System.out.println("음료가 준비되었습니다");

        // 주문
        if(quantity > stock) {
            System.out.println("재고가 부족합니다");
        } else {
            orderRepository.order(productId,quantity);
            int orderHistoryId = orderRepository.orderSave(userId);
            orderRepository.orderDetailSave(orderHistoryId,productId,quantity);
        }
    }
}
