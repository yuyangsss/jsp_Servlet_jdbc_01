package com.repository;

import com.entity.Student;
import com.mysql.cj.protocol.Resultset;
import com.util.JdbcTools;

import java.sql.*;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class StudentRepository {

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;


        try {
            //代码重复使用，改用util包下的jdbcTools类
//            Class.forName("com.mysql.cj.jdbc.Driver");
//           String url="jdbc:mysql://localhost:3306/teacher?useUnicode=true&characterEncoding=UTF-8";
//            String user="root";
//            String password="root";
//            connection= DriverManager.getConnection(url,user,password);
            connection = JdbcTools.getConnection();
            String sql = "select * from student";
            preparedStatement = connection.prepareStatement(sql);
            resultset = preparedStatement.executeQuery();
            Student student = null;

            while (resultset.next()) {
                Integer id = resultset.getInt(1);
                String name = resultset.getString(2);
                Integer age = resultset.getInt(3);
                Date date = resultset.getDate(4);
                student = new Student(id, name, age, date);
                list.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcTools.release(connection, preparedStatement, resultset);
        }
        return list;
    }

    public void add(String name, Integer age) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url="jdbc:mysql://localhost:3306/teacher?useUnicode=true&characterEncoding=UTF-8";
//            String user="root";
//            String password="root";
//            connection = DriverManager.getConnection(url, user, password);
            connection = JdbcTools.getConnection();
            String sql = "insert into student(name,age,date) values(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setDate(3, new java.sql.Date(1));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcTools.release(connection, preparedStatement, null);
        }
    }

    public void deleteByid(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcTools.getConnection();
            String sql = "delete from student where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcTools.release(connection, preparedStatement, null);
        }
    }


    public Student findByid(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        Student student=null;
        try {

            connection = JdbcTools.getConnection();
            String sql = "select * from student where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()){
                Integer id2=resultset.getInt(1);
                String name=resultset.getString(2);
                Integer age=resultset.getInt(3);
                Date date=resultset.getDate(4);
                student=new Student(id2,name,age,date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcTools.release(connection, preparedStatement, resultset);
        }
        return student;
    }
    public void update(Integer id,String name,Integer age) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcTools.getConnection();
            String sql = "update student set name=?,age=? where id=?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcTools.release(connection, preparedStatement, null);
        }
    }
            //下面是测试的
//    public static void main(String[] args) {
//        StudentRepository studentRepository=new StudentRepository();
//        System.out.println(studentRepository.findAll());
//    }
        }
