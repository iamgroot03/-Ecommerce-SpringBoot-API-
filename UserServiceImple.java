package com.example.demo.serviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Enities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserServices;


@Service
public class UserServiceImple implements UserServices{
	
	@Autowired
	private UserRepository repository;

	@Override
	public User addUser(User user) {
		repository.save(user);
		return user;
	}

	@Override
	public List<User> getUsers() {
		return repository.findAll();
	}

	@Override
	public Optional<User> getUserById(Long userId) {
		return repository.findById(userId);
	}

	@Override
	public User updateUser(User user,Long userId) {
		repository.findById(userId);
		repository.save(user);
		return user;
		
	}

	@Override
	public void deleteUser(Long userId) {
		User user=repository.getOne(userId);
		repository.delete(user);		
		
	}

}
