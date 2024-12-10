package app;

import classes.Admin;
import classes.Customer;
import classes.Authenticate;
import classes.User;
import classes.FileHandler;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        List<User> users;
        boolean login = false;
        User loggedUser = null;

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

                        System.out.print("Email: ");
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
                    adminMenu(scanner, users, loggedUser);
                } else if (loggedUser instanceof Customer) {
                    customerMenu(scanner, (Customer) loggedUser);
                }

                login = false;
                loggedUser = null;
            }
        }
        try {
            FileHandler.saveUsers(users);
        } catch (Exception e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    private static void adminMenu(Scanner scanner, List<User> users, User loggedUser) {
        int option = 0;

        do {
            System.out.println("\nWelcome, administrator " + loggedUser.getName());
            System.out.println("1. Create new user");
            System.out.println("2. View all users");
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
                    break;
                case 2:
                
                    break;
                case 3:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 3);
    }


    private static void customerMenu(Scanner scanner, Customer customer) {
        int option = 0;
        do {
            System.out.println("\nWelcome, " + customer.getName() + "! How can we help you?");
            System.out.println("1. View profile");
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
