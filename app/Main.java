package app;

import classes.*;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        List<User> users;
        List<Product> products;
        boolean login = false;
        User loggedUser = null;

        try {
            products = FileHandler.loadProducts();
        } catch (Exception e) {
            System.out.println("No products found. Starting with an empty list.");
            products = new ArrayList<>();
        }

        try {
            users = FileHandler.loadUsers();
        } catch (Exception e) {
            System.out.println("No users found. Starting with an empty list.");
            users = new ArrayList<>();
        }

        if (users.isEmpty()) {
            try {
                users.add(new Admin("admin", "admin@default.com", "admin"));
                System.out.println("Default admin created: admin / admin");
            } catch (Exception e) {
                System.out.println("Unable to create default admin: " + e.getMessage());
                return;
            }
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Exit");

            System.out.print("Choose an option: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (choice == 2) {
                System.out.println("Exiting system. Goodbye!");
                break;
            }

            if (choice == 1) {
                while (!login) {
                    try {
                        System.out.println("Welcome! Please login:");

                        System.out.print("Name: ");
                        String email = scanner.nextLine();

                        System.out.print("Password: ");
                        String password = scanner.nextLine();

                        loggedUser = Authenticate.login(users, email, password);

                        login = true;
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                        System.out.println("Please try again.");
                    }
                }

                if (loggedUser instanceof Admin) {
                    Admin.adminMenu(scanner, users, products, loggedUser);

                } else if (loggedUser instanceof Customer) {
                    Customer.customerMenu(scanner, (Customer) loggedUser);
                }

                login = false;
                loggedUser = null;
            }
        }
        try {
            FileHandler.saveUsers(users);
            FileHandler.saveProducts(products);
        } catch (Exception e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }



}