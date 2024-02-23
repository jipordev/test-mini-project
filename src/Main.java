import methods.CRUDImpl;
import model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static CRUDImpl crud = new CRUDImpl();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>(){{
           add(new Product("CSTAD001","Coca",20.0,50,LocalDate.now()));
           add(new Product("CSTAD001","Coca",20.0,50,LocalDate.now()));
           add(new Product("CSTAD003","Coca",20.0,50,LocalDate.now()));
           add(new Product("CSTAD004","Coca",20.0,50,LocalDate.now()));
           add(new Product("CSTAD001","Coca",20.0,50,LocalDate.now()));
           add(new Product("CSTAD001","Coca",20.0,50,LocalDate.now()));
           add(new Product("CSTAD001","Coca",20.0,50,LocalDate.now()));
           add(new Product("CSTAD001","Coca",20.0,50,LocalDate.now()));
        }};
        do {
            System.out.println("""
                #############################################################
                (Dis)play (Ra)ndom (C)reate (R)ead (D)elete (U)pdate (S)earch
                #############################################################""");
            System.out.print("Please choose options : ");
            String op = scanner.nextLine();
            switch (op){
                case "dis" -> {
                    productList = crud.readProductsFromFile("product.bak");
                    crud.displayAllProduct(productList);
                }
                case "ra" -> crud.randomRecord(productList);
                case "c" -> crud.createProduct(productList);
                case "r" -> crud.readProduct(productList);
                case "d" -> crud.deleteProduct(productList);
                case "u" -> crud.updateProduct(productList);
                case "s" -> crud.searchProductByName(productList);
            }
        } while (true);

    }
}