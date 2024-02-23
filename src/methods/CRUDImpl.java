package methods;

import model.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CRUDImpl implements CRUD{
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void randomRecord(List<Product> productList) {
        System.out.print("Enter amount of record : ");
        int randomNumber = Integer.parseInt(scanner.nextLine());
        Product[] products = new Product[randomNumber];
        for (int i = 0; i<randomNumber; i++) {
            products[i] = new Product();
            products[i].setProductCode("CSTAD00"+ i);
            products[i].setProductName("null");
            products[i].setProductPrice(0.0);
            products[i].setQty(0);
            products[i].setDate(LocalDate.now());
        }
        productList.addAll(List.of(products));
    }

    @Override
    public void createProduct(List<Product> productList) {
        Product product = new Product();
        System.out.print("Enter CODE : ");
        product.setProductCode(scanner.nextLine());
        System.out.print("Enter NAME : ");
        product.setProductName(scanner.nextLine());
        System.out.print("Enter PRICE : ");
        product.setProductPrice(Double.parseDouble(scanner.nextLine()));
        System.out.print("Enter QTY : ");
        product.setQty(Integer.parseInt(scanner.nextLine()));
        product.setDate(LocalDate.now());
        productList.add(product);
    }

    @Override
    public void deleteProduct(List<Product> productList) {
        System.out.print("Enter product code : ");
        String code = scanner.nextLine();
        productList.removeIf(product -> product.getProductCode().equals(code));
    }

    @Override
    public void readProduct(List<Product> productList) {
        System.out.print("Enter product code : ");
        String code = scanner.nextLine();
        for (Product product : productList) {
            if (product.getProductCode().equals(code)){
                System.out.println("#######################################");
                System.out.println("Product code  : " + product.getProductCode());
                System.out.println("Product Name  : " + product.getProductName());
                System.out.println("Product Price : " + product.getProductPrice());
                System.out.println("Product QTY   : " + product.getQty());
                System.out.println("Product Date  : " + product.getDate());
            }
        }
    }

    @Override
    public void updateProduct(List<Product> productList) {
        Product updateProduct = new Product();
        System.out.println("""
                1. Update all
                2. Update name
                3. Update Price
                4. Update Qty
                """);
        System.out.print("Choose option to update : ");
        int op = Integer.parseInt(scanner.nextLine());
        switch (op) {
            case 1 -> {
                System.out.print("Enter product code : ");
                String code = scanner.nextLine();
                for (Product product : productList) {
                    if (product.getProductCode().equals(code)) {
                        System.out.println("#######################################");
                        System.out.println("Product code  : " + product.getProductCode());
                        System.out.println("Product Name  : " + product.getProductName());
                        System.out.println("Product Price : " + product.getProductPrice());
                        System.out.println("Product QTY   : " + product.getQty());
                        System.out.println("Product Date  : " + product.getDate());

                        System.out.print("Enter NAME : ");
                        updateProduct.setProductName(scanner.nextLine());
                        System.out.print("Enter PRICE : ");
                        updateProduct.setProductPrice(Double.parseDouble(scanner.nextLine()));
                        System.out.print("Enter QTY : ");
                        updateProduct.setQty(Integer.parseInt(scanner.nextLine()));
                        updateProduct.setDate(LocalDate.now());
                        updateProduct.setProductCode(product.getProductCode());
                        productList.set(productList.indexOf(product), updateProduct);
                    }
                }
            }
        }
    }

    @Override
    public void displayAllProduct(List<Product> productList) {
        for (Product product : productList) {
            System.out.println("#######################################");
            System.out.println("Product code  : " + product.getProductCode());
            System.out.println("Product Name  : " + product.getProductName());
            System.out.println("Product Price : " + product.getProductPrice());
            System.out.println("Product QTY   : " + product.getQty());
            System.out.println("Product Date  : " + product.getDate());
        }
    }

    @Override
    public void searchProductByName(List<Product> productList) {
        System.out.print("Enter product code : ");
        String code = scanner.nextLine();
        for (Product product : productList){
            if (product.getProductCode().contains(code)){
                displayAllProduct(productList);
            }
        }
    }
}
