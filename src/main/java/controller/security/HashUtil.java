package controller.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Util class containing methods for hashing strings using various algorithms
 */
public class HashUtil {

    /**
     * @return user password hashed using MD5 algorithm, or an empty string in case
     * no valid password was passed as an argument
     */
    public static String generateMD5HashedPassword(String password) {
        String generatedPassword = "";
        if (password == null || password.equals("")) {
            return "";
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
