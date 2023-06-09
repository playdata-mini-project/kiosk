package service;

import domain.entity.Product;
import repository.CategoryRepository;
import repository.ProductRepository;

public class ProductService {

    private static ProductService productService;
    private final static ProductRepository productRepository = new ProductRepository();

    public Product findById(int id){
        return productRepository.findById(id);
    }
}
