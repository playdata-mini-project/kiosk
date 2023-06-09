package controller;

import domain.entity.Product;
import service.CategoryService;
import service.OrderService;
import service.ProductService;
import utility.LoginUser;

import java.util.Scanner;

public class CategoryController {

    private final CategoryService categoryService = CategoryService.getInstance();
    private final ProductService productService = ProductService.getInstance();
    private final OrderService orderService = OrderService.getInstance();

    public void selectMode(){

        System.out.println("카테고리 번호를 입력해주세요");
        categoryService.printCategoryList();

        Scanner sc = new Scanner(System.in);

        while(true){

            int categoryId = sc.nextInt();
            System.out.println(categoryId);
            productService.printProductsByCategoryId(categoryId);
            System.out.println("상품 번호를 입력해주세요");

            int productId = sc.nextInt();
            System.out.println("수량을 입력해주세요");
            int amount = sc.nextInt();

            orderService.order(LoginUser.getId(), productId, amount);
        }
    }

}
