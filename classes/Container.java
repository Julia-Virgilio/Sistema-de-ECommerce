package classes;

import java.io.Serializable;
import java.util.List;

public class Container implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<User> users;
    private List<Product> products;

    public Container(List<User> users, List<Product> products) {
        this.users = users;
        this.products = products;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
