package service;

import domain.dto.OrderHistoryDto;
import domain.dto.ProductDto;
import repository.ManagerRepository;
import java.util.List;

public class ManagerService {
    private static ManagerService managerService;

    public static ManagerService getInstance() {
        if(managerService==null) managerService = new ManagerService();
        return managerService;
    }


    public List<ProductDto> stockCheck() {
        List<ProductDto> productList = new ManagerRepository().stockCheck();
        for (ProductDto productDto : productList) {
            System.out.println();
            System.out.print(productDto.getId() + ". " + productDto.getName() + " | " + productDto.getQuantity());
        }
        return productList;
    }

    public List<OrderHistoryDto> orderCheck() {
        List<OrderHistoryDto> orderList= new ManagerRepository().orderCheck();
        for (OrderHistoryDto orderHistotyDto : orderList){
            System.out.println();
            System.out.println(orderHistotyDto.getId() + ". " + orderHistotyDto.getUserId()
                    + " | "+ orderHistotyDto.getAmount()+ " | " + orderHistotyDto.getOrderedAt());
        }
        return orderList;
    }
}
