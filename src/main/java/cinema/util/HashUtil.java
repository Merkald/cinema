package cinema.util;

import cinema.exeptions.AuthenticationExeption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.apache.log4j.Logger;

public class HashUtil {
    private static Logger logger = Logger.getLogger(HashUtil.class);
    private static final String SHA_512 = "SHA-512";

    public static byte[] getSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;
    }

    public static String hashPassword(String password, byte[] salt) {

        StringBuilder hashedPassword = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SHA_512);
            messageDigest.update(salt);
            byte[] digest = messageDigest.digest(password.getBytes());
            for (byte b : digest) {
                hashedPassword.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException e) {
            throw new AuthenticationExeption("Can't create hashing password ", e);
        }
        return hashedPassword.toString();
    }
}
