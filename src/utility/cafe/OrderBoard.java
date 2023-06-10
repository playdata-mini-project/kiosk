package utility.cafe;

import domain.entity.Product;
import domain.entity.User;

public class OrderBoard {

    private int orderNumber;
    private User user;
    private Product product;
    private boolean isComplete;

    private OrderBoard(int orderNumber, User user, Product product) {
        this.orderNumber = orderNumber;
        this.user = user;
        this.product = product;
        this.isComplete = false;
    }
    public void changeIsComplete(){
        isComplete = !isComplete;
    }

    public static OrderBoard createOrder(int orderNumber, User user, Product product){
        OrderBoard orderBoard = new OrderBoard(orderNumber, user, product);
        return orderBoard;
    }
    @Override
    public String toString() {
        return "주문번호 : " + orderNumber + "번 " + user.getName() + "고객님이 주문한 " + product.getName() + " 준비상태" + isComplete;
    }
}
