package service;

import repository.CategoryRepository;


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
        categoryRepository.getCategoryList();
    }
}
