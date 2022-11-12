package ru.gb.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProductRepository {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    {
        double cost = 0;
        for (long i = 0; i < 5; i++) {
            productMap.put(i, new Product(i, "Product " + i, cost + (int) (Math.random() * 100)));
        }
    }

    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public void saveOrUpdate(Product product) {
        if (product.getId() == null) {
            Long id = Collections.max(productMap.keySet()) + 1;
            product.setId(id);
        }
        productMap.put(product.getId(), product);
    }

    public Product findProduct(Long id) { return productMap.get(id); }

    public void removeProduct(Long id) {
        productMap.remove(id);
    }
}