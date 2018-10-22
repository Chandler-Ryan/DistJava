package com.chandlerryan;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    Product getProduct(String ProdNum);
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(String ProdNum);
}
