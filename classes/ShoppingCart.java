package classes;

import java.util.Map;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class ShoppingCart implements Serializable{
    private static final long serialVersionUID = 1L;
    private Map<Product, Integer> products;
    double totalPrice;

    public ShoppingCart(){
        this.totalPrice = 0;
        this.products = new HashMap<Product, Integer>();
    }

    public void addProduct(Product product, Scanner scanner) {
        if (product.getStock() == 0) {

            System.out.println("Sorry, we can't add this product! We're out of it :(");
        } else {
            System.out.println("How many of this product would you like?");
            int quantity;
    
            try {
                quantity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                return; 
            }
    
            if (quantity > product.getStock()) {
                System.out.println("Sorry, we can't add this quantity! We only have " 
                        + product.getStock() + " in stock.");   
            } else {
                products.put(product, quantity);
                System.out.println(product.getName() + " added to your shopping cart.");
            }
        }
    }

    public void viewCart() {
        if (products.isEmpty()) {
            System.out.println("\nYour cart is empty. Why don't you try to add a product here?");
            
        } else {
            
            System.out.println("\nProducts in your cart:");

            for (Map.Entry<Product, Integer> entry : products.entrySet()) {
                Product p = entry.getKey();
                int quantity = entry.getValue();
                System.out.println(p.getName() + " - $" + p.getPrice() + " x " + quantity);
            }
                
            double total = getPrice();
            System.out.println("Total: $" + total);
        }
    }

    public void clearCart(){
        totalPrice = 0;
        products.clear();
    }

    public Map<Product, Integer> getProducts(){
        return products;
    }

    public double getPrice(){
        double total = 0;

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product p = entry.getKey();
            int quantity = entry.getValue();
            total += p.getPrice() * quantity;
        }
        
       return total;
    }

}
