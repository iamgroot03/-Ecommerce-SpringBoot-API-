package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.Enities.User;

public interface UserServices {
	
	public User addUser(User user);
	
	public List<User> getUsers();
	
	public Optional<User> getUserById(Long userId);
	
	public User updateUser(User user,Long userId);
	
	public void deleteUser(Long userId);

}
