package controller;

import domain.entity.Product;
import service.CategoryService;
import service.ProductService;
import utility.LoginUser;

import java.util.Scanner;

public class CategoryController {

    private static final CategoryService categoryService = CategoryService.getInstance();
    private static final ProductService productService = ProductService.getInstance();
    public void selectMode(){

        System.out.println("카테고리 번호를 입력해주세요");
        categoryService.printCategoryList();

        Scanner sc = new Scanner(System.in);

        while(true){

            int categoryId = Integer.parseInt(sc.nextLine());
            productService.printProductsByCategoryId(categoryId);
            System.out.println("상품 번호를 입력해주세요");

            int productId = Integer.parseInt(sc.nextLine());
            System.out.println("수량을 입력해주세요");
            int amount = Integer.parseInt(sc.nextLine());

        }
    }

}
