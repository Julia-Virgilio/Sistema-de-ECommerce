package classes;

import java.util.List;

public class Authenticate {
    public static User login(List<User> users, String name, String password) throws Exception{

        for(User user : users){
            if(user.getName().equals(name) && user.authenticatePassword(password)){
                return user;
            }
        }
        throw new Exception("User not found.");
    }   
}
