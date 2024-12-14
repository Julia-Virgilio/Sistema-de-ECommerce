package classes;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int nextId = 1;
    private final int id; 
    private String name;
    private String description;
    private double price;
    private int stock;
    private String category;

    public Product(String name, String description, double price, int stock, String category) {
        this.id = nextId++;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public static void createProduct(Scanner scanner, List<Product> products) {
        System.out.println("\nCreate new product: ");

        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter description: ");
            String description = scanner.nextLine();

            System.out.print("Enter price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter category: ");
            String category = scanner.nextLine();

            System.out.print("How many are available in stock?: ");
            int stock = scanner.nextInt();

            Product newProduct = new Product(name, description, price, stock, category);
            products.add(newProduct);

            System.out.println("\nProduct created successfully!");

            System.out.println(newProduct.toString());

            scanner.nextLine();

        } catch (Exception e) {
            System.out.println("Error creating product: " + e.getMessage());
        }
    }

    public static void listProducts(List<Product> products) {
        System.out.println("\nLoading products...");

        if (products.isEmpty()) {
            System.out.println("There are no products available! Sorry :(");
        } else {
            for (Product product : products) {
                System.out.println(product.toString());
            }
        }
    }

    @Override
public String toString() {
    return "Product Details:" +
           "\nID: " + id +
           "\nName: " + name +
           "\nDescription: " + description +
           "\nCategory: " + category +
           "\nPrice: $ " + price +
           "\nStock: " + stock;
}
}
