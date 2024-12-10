package classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import classes.User;

public class FileHandler {
    private static final String FILE_NAME = "data.dat";

    // Método para salvar usuários no arquivo
    public static void saveUsers(List<User> users) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
        }
    }

    // Método para carregar usuários do arquivo
    public static List<User> loadUsers() throws IOException, ClassNotFoundException {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<User>) ois.readObject();
        }
    }
}
