package com.dao;

import com.pojos.User;

public class UserDAOImpl implements UserDAO
{

	@Override
	public int addUser(User user) 
	{
		
		return 0;
	}

	@Override
	public boolean updateEmailId(String username, String email) 
	{
		return false;
	}

	@Override
	public boolean updatePhone(String username, long phone) 
	{
		return false;
	}

	@Override
	public boolean updatePassword(String username, String password) 
	{
		return false;
	}

	@Override
	public User findUserByUsername(String username) 
	{
		return null;
	}

	@Override
	public User deleteUser(String username) 
	{
		return null;
	}

}
