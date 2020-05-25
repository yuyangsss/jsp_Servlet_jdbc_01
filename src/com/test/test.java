package com.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class test {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/teacher?useUnicode=true&characterEncoding=UTF-8";
            String user="root";
            String password="root";
            Connection connection= DriverManager.getConnection(url,user,password);
            System.out.println(connection);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
