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

public class FirmDAOImpl implements FirmDAO{

	
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
	public int addfirm(Firm firm) {
		// TODO Auto-generated method stub
		int rows_inserted = 0;
		
		String INSERT_FIRM = "insert into firms values(?,?)";
		
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(INSERT_FIRM);)
		{
			
			ps.setInt(1,firm.getFirmId());
			ps.setString(2, firm.getFirmName());
			rows_inserted = ps.executeUpdate();
			
//			System.out.println("Rows : "+rows_inserted);
//			conn.setAutoCommit(true);
			//conn.close();			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		
		return rows_inserted;

	
	}

	@Override
	public List<Firm> findAllFirms() {
		// TODO Auto-generated method stub
		List<Firm> firms = new ArrayList<Firm>();
		String FIND_ALL_FIRMS = "select * from firms";
	

		try(Connection conn = openConnection();Statement stmt = conn.createStatement();) 
		{
			ResultSet rs = stmt.executeQuery(FIND_ALL_FIRMS);
			
			while(rs.next())
			{
				int firmId=rs.getInt(1);
				String firmName = rs.getString(2);
				Firm firm= new Firm(firmId,firmName);
				firms.add(firm);
//		
			}
			System.out.println("List Size = "+firms.size());
			conn.setAutoCommit(true);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return firms;
	
	
	}

}
