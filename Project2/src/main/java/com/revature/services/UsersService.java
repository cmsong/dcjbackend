package com.revature.services;

import java.util.List;

import com.revature.models.Users;

public interface UsersService {
	
	public Users createUsers(Users users);
	public List<Users> getUsersByUsername(String username);
	public List<Users> allUsers();
	public Users updateUsers(Users change);
	public boolean deleteUsers(Users users);

}