package com.example.blood;

public class sql {
    private static String username="zun";
    private static String password="zun";
    public static String EncryptDecrypt(String inp)
    {
        String key = "blood lagbe";
        StringBuilder ret = new StringBuilder();
        for(int i = 0 ; i < inp.length() ; i++)
        {
            ret.append((char) (inp.charAt(i) ^ key.charAt(i % key.length())));
        }
        return ret.toString();
    }

}

/*
create table blood(
    email varchar2(20) primary key,
    password varchar2(20),
    emergencyPassword varchar2(20),
    fullname varchar2(20),
    dob date,
    division varchar2(20)
);

USERNAME IS FULLNAME?
 */