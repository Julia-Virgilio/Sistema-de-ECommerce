package classes;

import java.util.List;
import java.util.ArrayList;

public class Customer extends User{

    private String deliveryAddress;
    private List<String> history;

    public Customer(String name, String email, String password, String deliveryAddress) throws Exception{
        super(name, email, password);
        this.deliveryAddress = deliveryAddress;
        this.history = new ArrayList<>();
    }
}
