package com.example.blood;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class mySettings {
    public static int Width = 1280;
    public static int Height = 720;
    public static String fullname, password, email, division, district, gender, bloodgroup, rh_factor, contact_no, otp;
    public static double weight;
    public static LocalDate DOB; // might cause problems with SQL dates

    public static String passwordCheck(String givenPassword)
    {
        if(givenPassword.length() < 8)
            return "Password too short";

        boolean small = false, capital = false, num = false, special = false;
        for(int i = 0 ; i < givenPassword.length() ; i++)
        {
            if(givenPassword.charAt(i) >= 'a' && givenPassword.charAt(i) <= 'z')
                small = true;
            else if(givenPassword.charAt(i) >= 'A' && givenPassword.charAt(i) <= 'Z')
                capital = true;
            else if(givenPassword.charAt(i) >= '0' && givenPassword.charAt(i) <= '9')
                num = true;
            else special = true;
        }
        if(small == false)
            return "Password must have at least one small character";
        if(capital == false)
            return "Password must have at least one capital character";
        if(num == false)
            return "Password must have at least one number";
        if(special == false)
            return "Password must have at least one special character";
        return null;
    }

    public static String otpGenerator()
    {
        Random r = new Random();
        String ret = new String();
        for(int i = 0 ; i < 5 ; i++)
        {
            ret += (char) (r.nextInt(26) + 'A');
        }
        return ret;
    }
}
