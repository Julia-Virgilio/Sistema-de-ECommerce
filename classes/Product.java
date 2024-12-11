package classes;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Product {

    private static int nextId = 1;
    private final int id; 
    private String name;
    private String description;
    private double price;
    private int stock;
    private String category;

    public Product(String name, String description, double price, int stock, String category){
        this.id = nextId++;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public static void createProduct(Scanner scanner, List<Product> products){
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
    
            System.out.print("How many is available in stock?: ");
            int stock = Integer.parseInt(scanner.nextLine());

            Product newProduct = new Product(name, description, price, stock, category); 
            products.add(newProduct);

            System.out.println("Product created sucessfully!\n");

            System.out.println(name + "\n" + category + "\n" + description + "\nR$ " + price + 
                    "\nThere are available " + stock + " of this product.");
        
        } catch (Exception e) {
            System.out.println("Error creating product: " + e.getMessage());
        }
    }

    
}
