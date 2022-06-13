package com.ty.arsapp.service.impl;

import java.util.List;

import com.ty.arsapp.dao.impl.UserDaoImp;
import com.ty.arsapp.dto.Booking;
import com.ty.arsapp.dto.User;
import com.ty.arsapp.service.UserService;

public class UserServiceImp implements UserService {
	UserDaoImp userDaoImp = new UserDaoImp();

	@Override
	public User saveUser(User user) {
		return userDaoImp.saveUser(user);
	}

	@Override
	public User validateUser(String email, String password) {
		return userDaoImp.validateUser(email, password);
	}

	@Override
	public User getUser(int id) {
		return userDaoImp.getUser(id);
	}

	@Override
	public List<Booking> getUserReservations(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user, int id) {
		return userDaoImp.updateUser(user, id);
	}

	@Override
	public boolean deleteUser(int id) {
		return userDaoImp.deleteUser(id);
	}
	

}
