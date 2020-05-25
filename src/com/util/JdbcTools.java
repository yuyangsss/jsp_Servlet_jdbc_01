package com.util;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Collection;

public class JdbcTools {
    private static  Connection connection;
    private static  String url="jdbc:mysql://localhost:3306/teacher?useUnicode=true&characterEncoding=UTF-8";
    private static String user="root";
    private static String password="root";

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            connection=DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }
    public static void release(Connection connection, Statement statement, ResultSet resultset){
        try{
            if(connection!=null){
                connection.close();
            }
            if(statement!=null){
                connection.close();
            }
            if(resultset!=null){
               resultset.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
