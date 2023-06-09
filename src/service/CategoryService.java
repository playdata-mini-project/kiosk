package service;

import domain.entity.Category;
import repository.CategoryRepository;

import java.util.List;


public class CategoryService {
    private static CategoryService categoryService;
    private final static CategoryRepository categoryRepository = new CategoryRepository();
    private CategoryService(){};
    public static CategoryService getInstance(){
        if(categoryService == null){
            categoryService = new CategoryService();
        }
        return categoryService;
    }

    public void printCategoryList(){
        List<Category> categoryList = categoryRepository.getCategoryList();
        for (Category category : categoryList) {
            System.out.println(category);
        }
    }
}
