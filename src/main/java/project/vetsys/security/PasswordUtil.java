package project.vetsys.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



///utilizar este metodo cuando se cree el login con la interface, para que reciba la contraseña y la encripte
///se debe hacer la comparación en el login de la ingresada con la guardada en la base de datos, pero con el metodo de encriptación
public class PasswordUtil { //recibe la contraseña y retorna otra cadena encriptada
    
    public static String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); //metodo de encriptacion de contraseñas
            
            //pasar a hash
            byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña: " + e.getMessage());
        }
    }
    
    public static boolean checkPassword(String plainPassword, String storedHash) {
        String hashedInput = encryptPassword(plainPassword);
        return hashedInput.equals(storedHash);
    }
}
