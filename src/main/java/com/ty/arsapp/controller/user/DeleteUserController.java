package com.ty.arsapp.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.arsapp.dto.User;
import com.ty.arsapp.service.impl.EmployeeServiceImp;
import com.ty.arsapp.service.impl.UserServiceImp;

@WebServlet(value = "/deleteUser")
public class DeleteUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		HttpSession httpSession = req.getSession();

		String email = (String) httpSession.getAttribute("email");
		String password = (String) httpSession.getAttribute("password");

		UserServiceImp userServiceImp = new UserServiceImp();
		User user = userServiceImp.validateUser(email, password);

		if (user != null) {
			UserServiceImp userServiceImp1 = new UserServiceImp();
			boolean res = userServiceImp1.deleteUser(id);
			if (res) {
				resp.sendRedirect("welcome.jsp");
			}
		} else {
			resp.sendRedirect("login.jsp");
		}
	}

}
