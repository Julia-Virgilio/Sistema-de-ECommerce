package classes;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Customer extends User{

    private String deliveryAddress;
    private List<Order> shoppingHistory;
    private ShoppingCart currentShoppingCart;

    public Customer(String name, String email, String password, String deliveryAddress) throws Exception{
        super(name, email, password);
        this.deliveryAddress = deliveryAddress;
        this.shoppingHistory = new ArrayList<>();
        this.currentShoppingCart = new ShoppingCart();
    }

    public static void customerMenu(Scanner scanner, Customer customer) {
        int option = 0;
        do {
            System.out.println("\nWelcome, " + customer.getName() + "! How can we help you?");
            System.out.println("1. Start new order");
            System.out.println("2. Exit to main menu");

            System.out.print("Choose an option: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.println("\nProfile Information:");
                    System.out.println(customer);
                    break;
                case 2:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 2);
    }
}
