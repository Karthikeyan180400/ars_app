package com.ty.arsapp.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.arsapp.dto.User;
import com.ty.arsapp.service.impl.UserServiceImp;

@WebServlet(value = "/viewUser")
public class ViewUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();

		String email = (String) httpSession.getAttribute("email");
		String password = (String) httpSession.getAttribute("password");

		UserServiceImp userServiceImp = new UserServiceImp();
		User user = userServiceImp.validateUser(email, password);
		if (user != null) {
			req.setAttribute("user", user);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewUser.jsp");
			requestDispatcher.forward(req, resp);
		}

	}

}
