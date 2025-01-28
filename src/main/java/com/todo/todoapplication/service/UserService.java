package com.todo.todoapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todoapplication.models.User;
import com.todo.todoapplication.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository urepo;
	
	public User authenticate(String name,String password){
		User user = urepo.findByName(name);
		return user;
	}
	
	public void save(User user) {
		urepo.save(user);
	}

	public User findById(Long userId) {
		// TODO Auto-generated method stub
		return urepo.findById(userId).get();
	}
}
