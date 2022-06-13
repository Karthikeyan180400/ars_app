package com.ty.arsapp.service;

import java.util.List;

import com.ty.arsapp.dto.Booking;
import com.ty.arsapp.dto.User;

public interface UserService {
	User saveUser(User user);

	User validateUser(String email, String password);

	User getUser(int id);

	List<Booking> getUserReservations(int id);

	User updateUser(User user, int id);

	boolean deleteUser(int id);

}
