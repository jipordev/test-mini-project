package methods;

import model.Product;

import java.util.List;

public interface CRUD {
    List<Product> readProductsFromFile(String fileName);
    void randomRecord(List<Product> productList);
    void createProduct(List<Product> productList);
    void deleteProduct(List<Product> productList);
    void readProduct(List<Product> productList);
    void updateProduct(List<Product> productList);
    void displayAllProduct(List<Product> productList);
    void searchProductByName(List<Product> productList);
}
