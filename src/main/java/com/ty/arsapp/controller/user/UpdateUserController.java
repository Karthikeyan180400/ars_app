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

@WebServlet(value = "/updateUser")
public class UpdateUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();

		String email1 = (String) httpSession.getAttribute("email");
		String password1 = (String) httpSession.getAttribute("password");

		UserServiceImp userServiceImp1 = new UserServiceImp();
		User user3 = userServiceImp1.validateUser(email1, password1);

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		long phone = Long.parseLong(req.getParameter("phone"));

		if (user3 != null) {
			User user = new User();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setGender(gender);
			user.setPhone(phone);

			UserServiceImp userServiceImp = new UserServiceImp();
			User user2 = userServiceImp.updateUser(user, id);
			if (user2 != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(req, resp);

			} else {
				resp.sendRedirect("login.jsp");
			}
		} else {
			resp.sendRedirect("login.jsp");
		}
	}

}
