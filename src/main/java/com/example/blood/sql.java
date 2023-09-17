package com.example.blood;

import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

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
        String sqlQuery = "insert into blood values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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


            pStmt.setString(6, null);
            pStmt.setString(7, null);
            pStmt.setString(8, null);
            pStmt.setInt(9, 0);
            pStmt.setString(10, null);
            pStmt.setString(11, null);
            pStmt.setString(12, null);
            pStmt.setInt(13, -1);
            pStmt.setDate(14, null);
            pStmt.setInt(15, 0);
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
    public static void updateUser()
    {
        String sqlQuery = "update blood set fullname = ?, dob = ?, division = ?, district = ?, gender = ?, weight = ?, bloodgroup = ?, rh_factor = ?, contact_no = ?, rating = ?, lastDonated = ?, totalDonated = ? where email = ?";
        try{
            // step1 load the driver class
            Class.forName(FORNAME);

            // step2 create the connection object
            Connection con = DriverManager.getConnection(url, username, password);

            // step3 create the statement object
            PreparedStatement pStmt = con.prepareStatement(sqlQuery);
            pStmt.setString(1, mySettings.fullname);
            pStmt.setDate(2, Date.valueOf(mySettings.DOB));
            pStmt.setString(3, mySettings.division);


            pStmt.setString(4, mySettings.district);
            pStmt.setString(5, mySettings.gender);
            pStmt.setDouble(6, mySettings.weight);
            pStmt.setString(7, mySettings.bloodgroup);
            pStmt.setString(8, mySettings.rh_factor);
            pStmt.setString(9, mySettings.contact_no);
            pStmt.setDouble(10, mySettings.rating);
            if(mySettings.lastDonated != null)
                pStmt.setDate(11, Date.valueOf(mySettings.lastDonated));
            else pStmt.setDate(11, null);
            pStmt.setInt(12, mySettings.TotalDonated);
            pStmt.setString(13, mySettings.email);
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
    public static void updatePassword()
    {
        String sqlQuery = "update blood set password = ?, emergencypassword = ? where email = ?";
        try{
            // step1 load the driver class
            Class.forName(FORNAME);

            // step2 create the connection object
            Connection con = DriverManager.getConnection(url, username, password);

            // step3 create the statement object
            PreparedStatement pStmt = con.prepareStatement(sqlQuery);
            pStmt.setString(1, EncryptDecrypt(mySettings.password));
            pStmt.setString(2, EncryptDecrypt(mySettings.password));
            pStmt.setString(3, mySettings.email);
            pStmt.executeUpdate();
            mySettings.otp = mySettings.password;
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
    public static boolean checkPassword()
    {
        String sqlQuery = "select * from blood where email = ?";
        String acquiredPass = new String();
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
        return mySettings.password.equals(acquiredPass);
    }
    public static void fetchUser()
    {
        String sqlQuery = "select * from blood where email = ?";
        System.out.println("Fetching data");
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
                mySettings.fullname = rs.getString("fullname");
                mySettings.otp = rs.getString("emergencyPassword");
                mySettings.DOB = rs.getDate("dob").toLocalDate();
                mySettings.division = rs.getString("division");
                mySettings.district = rs.getString("district");
                mySettings.gender = rs.getString("gender");
                mySettings.weight = rs.getDouble("weight");
                mySettings.bloodgroup = rs.getString("bloodgroup");
                mySettings.rh_factor = rs.getString("rh_factor");
                mySettings.contact_no = rs.getString("contact_no");
                mySettings.otp = EncryptDecrypt(mySettings.otp);
                mySettings.rating = rs.getDouble("rating");
                if(rs.getDate("lastDonated") != null)
                    mySettings.lastDonated = rs.getDate("lastDonated").toLocalDate();
                else mySettings.lastDonated = null;
                mySettings.TotalDonated = rs.getInt("totalDonated");
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
        System.out.println("Fetch complete");
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
    public static boolean setOTP()
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
            boolean ret = MailService.sendMail(mySettings.email, MailService.PASSWORD_RESET_SUBJECT, MailService.PASSWORD_RESET_TEXT + "\n" + otp);
            pStmt.setString(1, EncryptDecrypt(otp));
            pStmt.setString(2, mySettings.email);
            pStmt.executeUpdate();
            mySettings.otp = otp;

            // step4 drop all the connections
            con.close();
            pStmt.close();
            return ret;
        } catch (SQLException e)
        {
            System.out.println(" Error while connecting to database. Exception code : " + e);
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static ArrayList<String> getDistricts(String division)
    {
        System.out.println("Getting districts");
        ArrayList<String> ret = new ArrayList<String>(0);
        String sqlQuery = "select * from location where division = ?";
        try{
            // step1 load the driver class
            Class.forName(FORNAME);

            // step2 create the connection object
            Connection con = DriverManager.getConnection(url, username, password);
            // step3 create the statement object
            PreparedStatement pStmt = con.prepareStatement(sqlQuery);
            pStmt.setString(1, division);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                String temp = rs.getString("district");
                ret.add(temp);
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
        for(int i = 0 ; i < ret.size() ; i++)
        {
            System.out.print(ret.get(i) + " ");
        }
        System.out.println("");
        return ret;
    }
}

/*
create table blood(
    email varchar2(40) primary key,
    password varchar2(40),
    emergencyPassword varchar2(40),
    fullname varchar2(40),
    dob date,
    division varchar2(40),
    district varchar2(40),
    gender varchar2(10),
    weight number,
    bloodgroup varchar2(5),
    rh_factor varchar2(4),
    contact_no varchar2(15),
    rating number,
    lastDonated date,
    totalDonated int
);

create table location(
    district varchar2(40) primary key,
    division varchar2(40)
);

USERNAME IS FULLNAME?
 */