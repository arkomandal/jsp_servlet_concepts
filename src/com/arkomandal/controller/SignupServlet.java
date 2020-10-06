package com.arkomandal.controller;

import java.io.IOException;

import com.arkomandal.model.SignupBean;
import com.arkomandal.service.SignupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SignupDao signupDao;

    public void init() {
    	signupDao = new SignupDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        SignupBean signupBean = new SignupBean();
        signupBean.setName(name);
        signupBean.setEmail(email);
        signupBean.setPassword(password);

        try {
            if (signupDao.validate(signupBean)) {
                response.sendRedirect("auth.jsp");
            } else {
                response.sendRedirect("auth.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}