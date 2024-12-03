package classes;

public class Admin extends User{
        private static final long serialVersionUID = 1L;

        public Admin(String name, String email, String password) throws Exception{
            super(name, email, password);
        }
   
}
