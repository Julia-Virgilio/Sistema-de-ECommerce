package classes;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Customer extends User{

    private String deliveryAddress;
    private List<Order> shoppingHistory;
    private ShoppingCart cart;

    public Customer(String name, String email, String password, String deliveryAddress) throws Exception{
        super(name, email, password);
        this.deliveryAddress = deliveryAddress;
        this.shoppingHistory = new ArrayList<>();
        this.cart = new ShoppingCart();
    }

    public ShoppingCart getCart(){
        return this.cart;
    }

    public List<Order> getShoppingHistory(){
        return this.shoppingHistory;
    }

    public String getDeliveryAddress(){
        return this.deliveryAddress;
    }

    public void customerMenu(Scanner scanner, Customer customer, List<Product> products) {
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
                    menuOrder(products, scanner);
                    break;
                case 2:
                    System.out.println("Returning to main menu. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 2);
    }

    public void addProduct(List<Product> products, Scanner scanner) {
        Product.listProducts(products);
    
        System.out.println("\nWhich products would you like? Enter its ID!");
        System.out.println("Please, write a single 'X' to exit.");
    
        while (true) {
            String option = scanner.nextLine().trim();
    
            if (option.equalsIgnoreCase("x")) {
                System.out.println("Exiting product selection.");
                break;
            }
    
            Product selectedProduct = null;
            int id;
    
            try {
                id = Integer.parseInt(option);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid product ID or 'X' to exit.");
                continue;
            }
    
            for (Product p : products) {
                if (p.getId() == id) {
                    selectedProduct = p;
                    break;
                }
            }
    
            if (selectedProduct == null)
                System.out.println("Product not found. Please try again.");
             else 
                cart.addProduct(selectedProduct, scanner);
            
        }
    }
    

    public void menuOrder(List<Product> products, Scanner scanner) {
        int optionOrder = 0;
    
        do {
            System.out.println("\nDo you wish to...");
            System.out.println("1. Add product to your cart");
            System.out.println("2. View your cart");
            System.out.println("3. Finish order");
            System.out.println("4. Exit");
    
            System.out.print("Choose an option: ");
            try {
                optionOrder = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
    
            switch (optionOrder) {
                case 1:
                    addProduct(products, scanner);
                    break;
                case 2:
                    cart.viewCart();
                    break;
                case 3:
                    Order order = new Order(this);
                    order.finishOrder(cart, scanner);
                case 4:
                    System.out.println("Exiting order menu.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (optionOrder != 4); 
    }
    
}

