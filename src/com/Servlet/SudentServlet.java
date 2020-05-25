package com.Servlet;


import com.entity.Student;
import com.repository.StudentRepository;
import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@WebServlet("/student")
public class SudentServlet extends HttpServlet {
    private StudentRepository studentRepository=new StudentRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=req.getParameter("method");
        if(method==null){
            method="findAll";
        }
        switch (method){
            case "findAll":
                //返回数据+视图
                studentRepository = new StudentRepository();
                List<Student> list = studentRepository.findAll();
                req.setAttribute("list", list);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
            case "delete":
                String idStr=req.getParameter("id");
                Integer id=Integer.parseInt(idStr);
                studentRepository.deleteByid(id);
                resp.sendRedirect("/student");
                break;
            case "findByid":
                idStr=req.getParameter("id");
                id=Integer.parseInt(idStr);
                req.setAttribute("student",studentRepository.findByid(id));
                req.getRequestDispatcher("update.jsp").forward(req,resp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String method=req.getParameter("method");
        switch (method){
            case "add":
                String name =req.getParameter("name");
                String ageSrc= req.getParameter("age");
                Integer age=Integer.parseInt(ageSrc);
                studentRepository.add(name,age);
                resp.sendRedirect("/student");
                break;
            case "update":
                String idStr=req.getParameter("id");
                Integer id=Integer.parseInt(idStr);
                name=req.getParameter("name");
                ageSrc= req.getParameter("age");
                age=Integer.parseInt(ageSrc);
                studentRepository.update(id,name,age);
                resp.sendRedirect("/student");
                break;

        }
       // resp.sendRedirect("/student"); 可以提出来

    }



}
