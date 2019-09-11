package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.pojos.Broker;

public class BrokerDAOImpl implements BrokerDAO {

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
	public int addBroker(Broker broker) 
	{
		int rows_inserted = 0;
		
		String INSERT_BROKER = "insert into brokers values(?)";
		
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(INSERT_BROKER);)
		{			
			ps.setString(1,broker.getBrokerName());
			rows_inserted = ps.executeUpdate();
			
			System.out.println("Rows : "+rows_inserted);
			conn.setAutoCommit(true);
			//conn.close();			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		
		return rows_inserted;
	}

	@Override
	public List<String> findAllBrokers()
	{
		List<String> brokers = new ArrayList<>();
		String FIND_ALL_BROKERS = "select * from brokers";
		
		try(Connection conn = openConnection();Statement stmt = conn.createStatement();) 
		{
			ResultSet rs = stmt.executeQuery(FIND_ALL_BROKERS);
			
			while(rs.next())
			{
				String brokerName = rs.getString(1);

				brokers.add(brokerName);			
			}
//			System.out.println("List Size = "+brokers.size());
//			conn.setAutoCommit(true);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return brokers;
	}

}
