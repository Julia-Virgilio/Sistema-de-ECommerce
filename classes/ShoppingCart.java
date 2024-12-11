package classes;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class ShoppingCart {
    List<Product> products;
    double totalPrice;

    public ShoppingCart(){
        this.totalPrice = 0;
        this.products = new ArrayList<>();
    }


}
