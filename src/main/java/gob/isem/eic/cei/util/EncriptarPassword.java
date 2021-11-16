package gob.isem.eic.cei.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
    public static void main(String[] args) {
        String password = "123";
        
        System.out.println("password = " + password);
        
        String passwordEncriptado = encriptarPassword(password);
        
        System.out.println("passwordEncriptado = " + passwordEncriptado);
        
    }
    
    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
