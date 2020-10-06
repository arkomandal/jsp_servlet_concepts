package com.arkomandal.controller;

import java.io.IOException;

import com.arkomandal.model.LoginBean;
import com.arkomandal.service.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setEmail(email);
		loginBean.setPassword(password);

		try {
			String username = loginDao.validate(loginBean);
			if (username != null) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("dashboard.jsp?success=1");
			} else {
				/*
				 * We can use request dispatcher only when the other servlet to which the
				 * request is being forwarded lies in the same application. On the other hand
				 * Send Redirect can be used in both the cases if the two servlets resides in a
				 * same application or in different applications.
				 */
				request.getRequestDispatcher("auth.jsp").include(request, response);  
//				response.sendRedirect("auth.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}