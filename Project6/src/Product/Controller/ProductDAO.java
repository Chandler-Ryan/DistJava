package Product.Controller;

import Product.Model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    Product getProduct(String ProdNum);
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(String ProdNum);
}
