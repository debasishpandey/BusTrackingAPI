package org.trackit.bustracking.utill;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

    public static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public static String encode(String password){
        return encoder.encode(password);
    }

    public static boolean checkPassword(String password, String encodedPassword){
        System.out.println(encode(password));
        return encoder.matches(password, encodedPassword);
    }
}
