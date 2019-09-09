package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojos.User;

public class UserDAOImpl implements UserDAO
{
	
	Connection openConnection()
	{
		
		Connection conn = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DRIVER LOADED SUCCESSFULLY");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "group8", "trade");
			System.out.println("CONNECTION OBTAINED");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
		}
		
		return conn;
	}

	@Override
	public int addUser(User user) 
	{
		int rows_inserted = 0;
		Connection conn = openConnection();
		String INSERT_USER = "insert into users values(NULL, NULL, NULL, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps;
			
		try
		{
			ps = conn.prepareStatement(INSERT_USER);
			
			ps.setString(1,user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmailId());
			ps.setLong(4, user.getPhone());
			ps.setDate(5, user.getDob());
			ps.setInt(6, 1);
			
			rows_inserted = ps.executeUpdate();
			
			System.out.println("Rows : "+rows_inserted);
			conn.close();			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		
		return rows_inserted;
	}

	@Override
	public boolean updateEmailId(String username, String email) 
	{
		boolean isUpdated = false;
		
		String UPDATE_EMAILID = "update users set email_id=? where username=?";
		
		try
		{
			PreparedStatement ps = openConnection().prepareStatement(UPDATE_EMAILID);
			ps.setString(1, email);
			ps.setString(2, username);
			
			int rows = ps.executeUpdate();
			if(rows>0)
				isUpdated = true;
			else
				isUpdated = false;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return isUpdated;
		
	}

	@Override
	public boolean updatePhone(String username, long phone) 
	{
		boolean isUpdated = false;
		
		String UPDATE_PHONE = "update users set phone=? where username=?";
		
		try
		{
			PreparedStatement ps = openConnection().prepareStatement(UPDATE_PHONE);
			ps.setLong(1, phone);
			ps.setString(2, username);
			
			int rows = ps.executeUpdate();
			if(rows>0)
				isUpdated = true;
			else
				isUpdated = false;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return isUpdated;
	}

	@Override
	public boolean updatePassword(String username, String password) 
	{
		boolean isUpdated = false;
		
		String UPDATE_PASSWORD = "update users set password=? where username=?";
		
		try
		{
			PreparedStatement ps = openConnection().prepareStatement(UPDATE_PASSWORD);
			ps.setString(1, password);
			ps.setString(2, username);
			
			int rows = ps.executeUpdate();
			if(rows>0)
				isUpdated = true;
			else
				isUpdated = false;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return isUpdated;
	}

	@Override
	public User findUserByUsername(String username) 
	{
		User user = new User();
		String FIND_BY_USERNAME = "select * from users where username=?";
		
		Connection conn = openConnection();
		PreparedStatement ps;
		
		try
		{
			ps = conn.prepareStatement(FIND_BY_USERNAME);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String password = rs.getString(5);
				String emailid = rs.getString(6);
				long phone = rs.getLong(7);
				Date dob = rs.getDate(8);
				int admin = rs.getInt(9);
				user.setUsername(username);
				user.setPassword(password);	
				user.setEmailId(emailid);
				user.setPhone(phone);
				user.setDob(dob);
				user.setAdmin(admin);
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User deleteUser(String username) 
	{
	String DELETE_USER = "delete from users where username=?";
		
		Connection conn = openConnection();
		PreparedStatement ps;
		
		User user = null;
		
		user = findUserByUsername(username);
		
		if(user!=null)
		{
			try
			{
				ps = conn.prepareStatement(DELETE_USER);
				ps.setString(1, username);
				ps.executeQuery();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}		
			return user;
		}
		else
		{
			user = new User();
			return user;
		}
	}

	@Override
	public void viewLiveMarket() {
		// TODO Auto-generated method stub
		
	}

}
