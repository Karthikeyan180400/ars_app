package com.ty.arsapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.arsapp.dao.UserDao;
import com.ty.arsapp.dto.Booking;
import com.ty.arsapp.dto.Employee;
import com.ty.arsapp.dto.User;

public class UserDaoImp implements UserDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	@Override
	public User saveUser(User user) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	@Override
	public User validateUser(String email, String password) {
		entityManager = entityManagerFactory.createEntityManager();
		String sql = "select u from User u where u.email=?1 and u.password=?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> users = query.getResultList();
		if (users.size() > 0) {
			for (User user : users) {
				return user;
			}
		}

		return null;
	}

	@Override
	public User getUser(int id) {
		entityManager = entityManagerFactory.createEntityManager();
		User user = entityManager.find(User.class, id);
		return user;
	}

	@Override
	public List<Booking> getUserReservations(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user, int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		User user2 = entityManager.find(User.class, id);
		user2.setName(user.getName());
		user2.setEmail(user.getEmail());
		user2.setPassword(user.getPassword());
		user2.setGender(user.getGender());
		user2.setPhone(user.getPhone());

		entityTransaction.begin();
		entityManager.merge(user2);
		entityTransaction.commit();
		return user2;
	}

	@Override
	public boolean deleteUser(int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		User user = entityManager.find(User.class, id);

		if (user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
