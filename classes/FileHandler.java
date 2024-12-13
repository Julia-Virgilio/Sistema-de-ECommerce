package classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String DATA_FILE = "data.dat";

    public static void saveData(List<User> users, List<Product> products) throws IOException {
        Container container = new Container(users, products);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(container);
        }
    }

    public static Container loadData() throws IOException, ClassNotFoundException {
        File file = new File(DATA_FILE);

        if (!file.exists()) {
            return new Container(new ArrayList<>(), new ArrayList<>());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Container) ois.readObject();
        }
    }
}
