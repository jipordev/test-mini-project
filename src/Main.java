import methods.CRUDImpl;
import model.Product;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    static CRUDImpl crud = new CRUDImpl();
    static Scanner scanner = new Scanner(System.in);
    public static  void main(String[] args) {
        int pageNumber =1;
        int pageSize= crud.setNewRow();
        List<Product> productList = new ArrayList<>();
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
                    crud.displayAllProduct(productList, pageNumber, pageSize);
                }
                case "o" -> {
                    crud.setPageSize(scanner);
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