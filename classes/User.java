package classes;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int nextId = 1;
    private final int id; 
    private String name;
    private String email;
    private String passwordHash;
    private byte[] salt;

    protected User(String name, String email, String password) throws Exception {
        this.id = nextId++;
        this.name = name;
        this.email = email;
        this.salt = createSalt();
        this.passwordHash = createHashpassword(password, salt);
    }

    public int getId() {
        return id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private byte[] createSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private String createHashpassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 65536;
        int keyLength = 128;
        char[] passwordChars = password.toCharArray();

        PBEKeySpec spec = new PBEKeySpec(passwordChars, salt, iterations, keyLength);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();

        return Base64.getEncoder().encodeToString(hash);
    }

    public boolean authenticatePassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String hash = createHashpassword(password, salt); 
        return this.passwordHash.equals(hash); 
    }

}