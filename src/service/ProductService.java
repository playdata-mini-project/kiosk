package service;

import domain.entity.Product;
import repository.CategoryRepository;
import repository.ProductRepository;

import java.util.List;

public class ProductService {

    private static ProductService productService;
    private final ProductRepository productRepository = new ProductRepository();
    public static ProductService getInstance(){
        if(productService == null){
            productService = new ProductService();
        }
        return productService;
    }

    public Product findById(int id){
        return productRepository.findById(id);
    }

    public void printProductsByCategoryId(int id){
        for (Product product : findByCategoryId(id)) {
            System.out.println(product);
        }
    }
    public List<Product> findByCategoryId(int id){
        return productRepository.findByCategoryId(id);
    }
}
