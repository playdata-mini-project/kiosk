package service;

import domain.dto.OrderHistoryDto;
import domain.dto.ProductDto;
import repository.ManagerRepository;
import java.util.List;

public class ManagerService {
    private static ManagerService managerService;
    private final ManagerRepository managerRepository = new ManagerRepository();
    public static ManagerService getInstance() {
        if(managerService==null) managerService = new ManagerService();
        return managerService;
    }


    public List<ProductDto> stockCheck() {
        List<ProductDto> productList = managerRepository.stockCheck();
        for (ProductDto productDto : productList) {
            System.out.println();
            System.out.print(productDto.getId() + ". " + productDto.getName() + " | " + productDto.getQuantity());
        }
        System.out.println();
        return productList;
    }

    public List<OrderHistoryDto> orderCheck() {
        List<OrderHistoryDto> orderList= managerRepository.orderCheck();
        for (OrderHistoryDto orderHistotyDto : orderList){
            System.out.println("주문번호 : " + orderHistotyDto.getId() + " 유저번호 : " + orderHistotyDto.getUserId()
                    + " 주문상품 : " +  orderHistotyDto.getName()+ " 주문수량 : "+ orderHistotyDto.getAmount()+ " 주문일시 : " + orderHistotyDto.getOrderedAt());
        }
        return orderList;
    }

    public void plusQuantity(int productId, int quantity) {
        managerRepository.plusQuantity(productId, quantity);
    }
}
