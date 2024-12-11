package classes;

import java.util.List;
import java.util.Scanner;

public class Admin extends User{
        private static final long serialVersionUID = 1L;

        public Admin(String name, String email, String password) throws Exception{
            super(name, email, password);
        }

        public static void adminMenu(Scanner scanner, List<User> users, List <Product> products, User loggedUser) {
            int option = 0;
    
            do {
                System.out.println("\nWelcome, administrator " + loggedUser.getName());
                System.out.println("1. Create new product");
                System.out.println("2. Create new user");
                System.out.println("3. Exit to main menu");
    
                System.out.print("Choose an option: ");
                try {
                    option = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }
    
                switch (option) {
                    case 1:
                        Product.createProduct(scanner, products);
                        break;
                    case 2:
                        Admin.createUser(scanner, users);
                        break;
                    case 3:
                        System.out.println("Returning to main menu.");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } while (option != 3);
        }
    

        private static void createUser(Scanner scanner, List<User> users) {
            System.out.println("\nCreate New User:");
        
            try {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
        
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
        
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
        
                System.out.print("Is this user an admin? (yes/no): ");
                String isAdminInput = scanner.nextLine().trim().toLowerCase();
        
                User newUser;
                if (isAdminInput.equals("yes")) {
                    newUser = new Admin(name, email, password);
                } else {
                    System.out.print("Enter delivery address: ");
                    String deliveryAddress = scanner.nextLine();
                    newUser = new Customer(name, email, password, deliveryAddress);
                }
        
                users.add(newUser);
                System.out.println("User created successfully!");
            } catch (Exception e) {
                System.out.println("Error creating user: " + e.getMessage());
            }
        }
}
