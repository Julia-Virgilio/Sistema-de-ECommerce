package classes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Order {
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

    
}
