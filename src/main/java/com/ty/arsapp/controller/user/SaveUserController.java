package com.ty.arsapp.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.arsapp.dto.User;
import com.ty.arsapp.service.impl.UserServiceImp;

@WebServlet(value = "/createUser")
public class SaveUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		long phone = Long.parseLong(req.getParameter("phone"));
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setGender(gender);
		user.setPhone(phone);
		
		UserServiceImp userServiceImp = new UserServiceImp();
		User  user2 = userServiceImp.saveUser(user);
		if(user2 != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

}
