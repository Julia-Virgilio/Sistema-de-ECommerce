package classes;

import java.util.List;
import java.util.ArrayList;

public class Authenticate {
    public static User login(List<User> users, String email, String password) throws Exception{

        for(User user : users){
            if(user.getEmail().equals(email) && user.authenticatePassword(password)){
                return user;
            }
        }
        throw new Exception("User not found.");
    }   
}
