package methods;

import model.Product;

import java.util.List;

public interface CRUD {
    void createProduct(List<Product> productList);
    void deleteProduct(List<Product> productList);
    void updateProduct(List<Product> productList);
    void displayProduct(List<Product> productList);
    void searchProductByName(List<Product> productList);
}
