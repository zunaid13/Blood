package com.example.blood;

import java.sql.*;

public class sql {
    private static String username="zun";
    private static String password="zun";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String FORNAME = "oracle.jdbc.driver.OracleDriver";
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
    public static boolean CheckEmailAvailability()
    {
        String sqlQuery = "select * from blood where email = ?";
        try{
            // step1 load the driver class
            Class.forName(FORNAME);
            // step2 create the connection object
            Connection con = DriverManager.getConnection(url, username, password);

            // step3 create the statement object

            PreparedStatement pStmt = con.prepareStatement(sqlQuery);
            pStmt.setString(1, mySettings.email);
            ResultSet rs = pStmt.executeQuery();



            boolean ret = !rs.next();
            // step4 drop all the connections
            con.close();
            pStmt.close();
            rs.close();
            return ret;
        } catch (SQLException e)
        {
            System.out.println(" Error while connecting to database. Exception code : " + e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static void addUser()
    {
        String sqlQuery = "insert into blood values (?, ?, ?, ?, ?, ?)";
        try{
            // step1 load the driver class
            Class.forName(FORNAME);

            // step2 create the connection object
            Connection con = DriverManager.getConnection(url, username, password);

            // step3 create the statement object
            PreparedStatement pStmt = con.prepareStatement(sqlQuery);
            String encryptedPassword = EncryptDecrypt(mySettings.password);
            pStmt.setString(1, mySettings.email);
            pStmt.setString(2, encryptedPassword);
            pStmt.setString(3, encryptedPassword);
            pStmt.setString(4, mySettings.fullname);
            pStmt.setDate(5, Date.valueOf(mySettings.DOB));
            pStmt.setString(6, mySettings.division);
            pStmt.executeUpdate();

            // step4 drop all the connections
            con.close();
            pStmt.close();
//            rs.close();
        } catch (SQLException e)
        {
            System.out.println(" Error while connecting to database. Exception code : " + e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean checkPassword()
    {
        String sqlQuery = "select * from blood where email = ?";
        String acquiredPass = new String();
        String backupPass = new String();
        try{
            // step1 load the driver class
            Class.forName(FORNAME);

            // step2 create the connection object
            Connection con = DriverManager.getConnection(url, username, password);

            // step3 create the statement object
            PreparedStatement pStmt = con.prepareStatement(sqlQuery);
            pStmt.setString(1, mySettings.email);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                acquiredPass = rs.getString(2);
                backupPass = rs.getString(3);
            }
            // step4 drop all the connections
            con.close();
            pStmt.close();
            rs.close();
        } catch (SQLException e)
        {
            System.out.println(" Error while connecting to database. Exception code : " + e);
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        acquiredPass = EncryptDecrypt(acquiredPass);
        backupPass = EncryptDecrypt(backupPass);
        return mySettings.password.equals(acquiredPass) || mySettings.password.equals(backupPass);
    }

    public static void resetOTP()
    {
        String sqlQuery = "update blood set emergencypassword = password where email = ?";
        try{
            // step1 load the driver class
            Class.forName(FORNAME);

            // step2 create the connection object
            Connection con = DriverManager.getConnection(url, username, password);

            // step3 create the statement object
            PreparedStatement pStmt = con.prepareStatement(sqlQuery);
            pStmt.setString(1, mySettings.email);
            pStmt.executeUpdate();

            // step4 drop all the connections
            con.close();
            pStmt.close();
        } catch (SQLException e)
        {
            System.out.println(" Error while connecting to database. Exception code : " + e);
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
    public static void setOTP()
    {
        String sqlQuery = "update blood set emergencypassword = ? where email = ?";
        try{
            // step1 load the driver class
            Class.forName(FORNAME);

            // step2 create the connection object
            Connection con = DriverManager.getConnection(url, username, password);

            // step3 create the statement object
            PreparedStatement pStmt = con.prepareStatement(sqlQuery);
            String otp = mySettings.otpGenerator();
            MailService.sendMail(mySettings.email, MailService.PASSWORD_RESET_SUBJECT, MailService.PASSWORD_RESET_TEXT + "\n" + otp);
            pStmt.setString(1, EncryptDecrypt(otp));
            pStmt.setString(2, mySettings.email);
            pStmt.executeUpdate();

            // step4 drop all the connections
            con.close();
            pStmt.close();
        } catch (SQLException e)
        {
            System.out.println(" Error while connecting to database. Exception code : " + e);
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}

/*
create table blood(
    email varchar2(40) primary key,
    password varchar2(40),
    emergencyPassword varchar2(40),
    fullname varchar2(40),
    dob date,
    division varchar2(40)
);

USERNAME IS FULLNAME?
 */