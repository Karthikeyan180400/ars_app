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

@WebServlet(value = "/userLogin")
public class ValidateUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserServiceImp userServiceImp = new UserServiceImp();
		User user = userServiceImp.validateUser(email, password);
		if (user != null) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("email", email);
			httpSession.setAttribute("password", password);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewUser");
			requestDispatcher.forward(req, resp);
		} else {
			resp.sendRedirect("popup.jsp");
		}
	}

}
