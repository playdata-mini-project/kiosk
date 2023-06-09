package controller;

import service.CategoryService;

import java.util.Scanner;

public class CategoryController {

    private static final CategoryService categoryService = CategoryService.getInstance();
    public void selectMode(){

        categoryService.printCategoryList();

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1. 커피 2. 티 3. 스무디");
            String mode = sc.nextLine();
        }
    }

}
