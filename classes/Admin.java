    package classes;

    import java.util.List;
    import java.util.Scanner;

    public class Admin extends User{

    public Admin(String name, String email, String password) throws Exception{
        super(name, email, password);
    }

    public void adminMenu(Scanner scanner, List<User> users, List <Product> products, User loggedUser) {
        int option = 0;

        while (option != 5) {
            System.out.println("\nWelcome, administrator " + loggedUser.getName());
            System.out.println("1. Create new product");
            System.out.println("2. Create new user");
            System.out.println("3. Report to me - most expensive order");
            System.out.println("4. Report to me - product with lowest inventory");
            System.out.println("5. Exit");

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
                    createUser(scanner, users);
                    break;
                case 3:
                    reportExpensiveOrder(users);
                    break;
                case 4:
                    reportProductLowest(products);
                    break;
                case 5:
                    System.out.println("Exiting system... Goodbye");
                default:
                    System.out.println("Invalid option.");
            }

        }
    }


    private void createUser(Scanner scanner, List<User> users) {
        System.out.println("\nCreate New User:");

        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            for (User user : users) {
                if(user.getEmail().equals(email)){
                    System.out.println("Error: email has already been used!");
                    return;
                }
            }

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            System.out.print("Is this user an admin? (yes/no): ");
            String isAdmin = scanner.nextLine().trim().toLowerCase();

            User newUser;
            if (isAdmin.equals("yes")) {
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

    public void reportExpensiveOrder(List<User> users){
        Order mostExpensive = null;

        for(User user : users){
            if(user instanceof Customer){
                Customer customer = (Customer) user;

                for(Order order : customer.getShoppingHistory()){
                    if(mostExpensive == null || order.getTotalAmount() > mostExpensive.getTotalAmount())
                        mostExpensive = order;
                }
            }
        }


        if(mostExpensive != null){
            System.out.println("\nThe most expensive order is: ");
            System.out.println(mostExpensive.toString());
        } else
            System.out.println("No orders were made yet.");
    }

    public void reportProductLowest(List<Product> products) {
        Product lowestInventory = null;
    
        for (Product product : products) {
            if (lowestInventory == null || product.getStock() < lowestInventory.getStock()) 
                lowestInventory = product;
            
        }
    
        if (lowestInventory != null) {
            System.out.println("\nThe product with the lowest inventory is: ");
            System.out.println(lowestInventory.toString());
        } else 
            System.out.println("No products were added yet.");
        
        }
    
}
