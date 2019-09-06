package com.dao;

import com.pojos.User;

public interface UserDAO
{
	int addUser(User user);						
	boolean updateEmailId(String username, String email);
	boolean updatePhone(String username, long phone);
	boolean updatePassword(String username, String password);
	User findUserByUsername(String username);
	User deleteUser(String username);
}
