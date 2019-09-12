package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

		String INSERT_SECURITY = "insert into securities values(?,?,?)";
		
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(INSERT_SECURITY);)
		{			
			ps.setInt(1,security.getSecurityId());
			ps.setString(2,security.getSecurityName());
			ps.setInt(3, security.getLotSize());
			
			rows_inserted = ps.executeUpdate();
			
			System.out.println("Rows : "+rows_inserted);
			conn.setAutoCommit(true);		
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
		
		try(Connection conn = openConnection();Statement stmt = conn.createStatement();) 
		{
			ResultSet rs = stmt.executeQuery(FIND_ALL_SECURITIES);
			
			while(rs.next())
			{
				int SecurityId=rs.getInt(1);
				String SecurityName = rs.getString(2);
				int lotSize = rs.getInt(3);
				Security security= new Security(SecurityId,SecurityName, lotSize);
				securities.add(security);
//			
			}
			System.out.println("List Size = "+securities.size());
			conn.setAutoCommit(true);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return securities;

	}

}
