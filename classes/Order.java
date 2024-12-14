package classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int nextId = 1;
    private int orderId;
    private Customer customer;
    private double totalAmount;
    private LocalDateTime orderDate;
    private String status;
    private Map<Product, Integer> products;

    public Order(Customer customer) {
        this.orderId = nextId++;
        this.customer = customer;
        this.products = new HashMap<>();
        this.totalAmount = 0;
        this.orderDate = LocalDateTime.now();
        this.status = "Pending";
    }

    public double getTotalAmount(){
        return this.totalAmount;
    }

    public void finishOrder(ShoppingCart shoppingCart, Scanner scanner){

        if(shoppingCart.getProducts().isEmpty()){
            System.out.println("Hey, there isn't any products in your cart yet! Try adding some.");
            return;

        } else{

            while (true) {
                shoppingCart.viewCart();

                System.out.println("Is everything you want in there? Should we finish your order? (yes/no):");
                String option = scanner.nextLine().trim().toLowerCase();

                switch (option) {
                    case "yes":
                        for (Map.Entry<Product, Integer> entry : shoppingCart.getProducts().entrySet()) {
                            Product product = entry.getKey();
                            int quantity = entry.getValue();

                            products.put(product, quantity);
                            product.setStock(product.getStock() - quantity);

                        }

                        status = "Completed";
                        customer.getShoppingHistory().add(this);
                        totalAmount = shoppingCart.getPrice();
                        shoppingCart.clearCart();

                        System.out.println("\nOrder completed!");
                        System.out.println(toString());

                        return;
                    case "no":
                        System.out.println("Returning to menu...");
                        return;
                 }

            }

         }   
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Delivery Address: ").append(customer.getDeliveryAddress()).append("\n");
        sb.append("Order Date: ").append(orderDate).append("\n");
        sb.append("Status: ").append(status).append("\n");

        sb.append("Products:\n");
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            sb.append(" - ").append(product.getName())
            .append(" (Quantity: ").append(quantity).append(", Price: R$ ")
            .append(String.format("%.2f", product.getPrice())).append(")\n");
        }

        sb.append("Total Amount: R$ ").append(String.format("%.2f", totalAmount)).append("\n");
        return sb.toString();
    }
}
