package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.model.Product;
import ru.gb.model.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findProduct(id);
    }

    public void add(Product product) {
        getProductList().add(product);
    }

    public void saveOrUpdate(Product product) {
        productRepository.saveOrUpdate(product);
    }

    public void deleteById(Long id) {
        productRepository.removeProduct(id);
    }

}
