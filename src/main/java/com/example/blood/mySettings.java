package com.example.blood;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class mySettings {
    public static int Width = 1280;
    public static int Height = 720;
    public static String fullname, password, email, division;
    public static LocalDate DOB; // might cause problems with SQL dates

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
