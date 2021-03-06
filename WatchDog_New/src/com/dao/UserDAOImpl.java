package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.randomstring;
import com.pojos.User;
//
public class UserDAOImpl implements UserDAO
{
	
	Connection openConnection()
	{
		
		Connection conn = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("DRIVER LOADED SUCCESSFULLY");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "group8", "trade");
//			System.out.println("CONNECTION OBTAINED");
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

		String IS_TAKEN = "select username from users where username = ?";
		String INSERT_USER = "insert into users values(?, NULL, NULL, ?, ?, ?, ?, ?, ?)";		
		
		try(Connection conn = openConnection();PreparedStatement ps1 = conn.prepareStatement(IS_TAKEN);)
		{
			ps1.setString(1, user.getUsername());
						
			ResultSet rs=ps1.executeQuery();
			System.out.println(rs);
			 int i=0;
			 while(rs.next())
			 {
				 i++;
			 }
			 if(i>0)
			 {
				 System.out.println("user name taken. please enter a different user name");
				 return 0;
			 }
			 else
			 {
					try(PreparedStatement ps = conn.prepareStatement(INSERT_USER);)
					{						
						String traderId = user.getUsername().substring(0, 3).toUpperCase()+randomstring.getAlphaNumericString(5);
						ps.setString(1, traderId);
						ps.setString(2,user.getUsername());
						ps.setString(3, user.getPassword());
						ps.setString(4, user.getEmailId());
						ps.setLong(5, user.getPhone());
						ps.setDate(6, user.getDob());
						ps.setInt(7, 1);
						
						rows_inserted = ps.executeUpdate();
						
						System.out.println("Rows : "+rows_inserted);
						conn.close();			
					}
					catch (SQLException e) 
					{
						e.printStackTrace();
					}	
					
			 }
			
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
		
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(UPDATE_EMAILID);)
		{
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
		
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(UPDATE_PHONE);)
		{
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
		
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(UPDATE_PASSWORD);)
		{
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
		
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(FIND_BY_USERNAME);)
		{
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
		User user = null;
		
		user = findUserByUsername(username);
	
		if(user!=null)
		{
			try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(DELETE_USER);)
			{
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
	public void viewLiveMarket() 
	{
		// TODO Auto-generated method stub
	
	}

}
