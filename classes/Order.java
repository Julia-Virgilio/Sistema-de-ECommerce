package classes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private double totalAmount;
    private LocalDateTime orderDate;
    private String status;

    public Order(int orderId, Customer customer, List<Product> products, double totalAmount) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
        this.totalAmount = totalAmount;
        this.orderDate = LocalDateTime.now();
        this.status = "Pending";
    }
}
