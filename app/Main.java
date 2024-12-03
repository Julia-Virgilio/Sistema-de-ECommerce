package app;

import classes.Admin;
import classes.Customer;
import classes.Authenticate;
import classes.User;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        List<User> users = new ArrayList<>();
        boolean login = false;
        User loggedUser = null;

        Scanner scanner = new Scanner(System.in);

        try {
            users.add(new Admin("Julia", "julia.virgilio@gmail.com", "password"));  
        }  catch (Exception e){
            System.out.println("Unable to create user.");
        }

        
        while(!login){

            try{
                System.out.println("Welcome!");

                System.out.println("Email: ");
                String email = scanner.nextLine();

                System.out.println("Password: ");
                String password = scanner.nextLine();
                
                loggedUser = Authenticate.login(users, email, password);

                login = true;

            }  catch (Exception e){ //try key here
                    System.err.println("Error: " + e.getMessage());
                    System.out.println("Please try again.\n");
            }
        }

        if(loggedUser instanceof Admin){
            int option = 0;

            while(option != 5){
                System.out.println("Welcome, administrator " + loggedUser.getname());

                System.out.println("\n1. Create new product");
                System.out.println("2. Create new user");
                System.out.println("3. Report - more expensive order");
                System.out.println("4. Report - product with lowest inventory");
                System.out.println("5. Exit");

                option = scanner.nextInt();

                switch(option){
                    case 5: 
                        login = false;
                        break;
                }
            }
        }

        if(loggedUser instanceof Customer){
            int option = 0;

            while(option != 2){
                System.err.println("Welcome, " + loggedUser.getname() + "!");

                System.out.println("\n1. Start new order");
                System.out.println("2. Exit");

                option = scanner.nextInt();

                switch(option){
                    case 2: 
                        login = false;
                        break;
                }
            }

            
        }
    }
}
