package classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String USERS_FILE = "users.dat";
    private static final String PRODUCTS_FILE = "products.dat";

    public static void saveUsers(List<User> users) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(users);
        }
    }

    public static List<User> loadUsers() throws IOException, ClassNotFoundException {
        File file = new File(USERS_FILE);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<User>) ois.readObject();
        }
    }

    public static void saveProducts(List<Product> products) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PRODUCTS_FILE))) {
            oos.writeObject(products);
        }
    }

    public static List<Product> loadProducts() throws IOException, ClassNotFoundException {
        File file = new File(PRODUCTS_FILE);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Product>) ois.readObject();
        }
    }
}
