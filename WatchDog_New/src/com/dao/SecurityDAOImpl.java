package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojos.Firm;
import com.pojos.Security;

public class SecurityDAOImpl implements SecurityDAO{
	
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
	public int addSecurity(Security security) {
		// TODO Auto-generated method stub
		
		int rows_inserted = 0;
		Connection conn = openConnection();
		String INSERT_SECURITY = "insert into securities values(?,?)";
		PreparedStatement ps;
		try
		{
			ps = conn.prepareStatement(INSERT_SECURITY);
			
			ps.setInt(1,security.getSecurityId());
			ps.setString(2,security.getSecurityName());
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
	public List<Security> findAllSecurity() {
		// TODO Auto-generated method stub
		List<Security> securities = new ArrayList<Security>();
		String FIND_ALL_SECURITIES = "select * from securities";
		
		Connection conn = openConnection();
		Statement stmt;
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(FIND_ALL_SECURITIES);
			
			while(rs.next())
			{
				int SecurityId=rs.getInt(1);
				String SecurityName = rs.getString(2);
				Security security= new Security(SecurityId,SecurityName);
				securities.add(security);
//			
			}
			System.out.println("List Size = "+securities.size());
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return securities;
	
	
	
	}

}
