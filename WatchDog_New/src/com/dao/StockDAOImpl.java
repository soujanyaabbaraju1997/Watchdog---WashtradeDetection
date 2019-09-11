package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.pojos.Stock;


public class StockDAOImpl implements StockDAO 
{
	Connection openConnection()
	{
		
		Connection conn = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DRIVER LOADED SUCCESSFULLY");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "group8", "trade");
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			System.out.println("CONNECTION OBTAINED");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
		}
		
		return conn;
	}

	@Override
	public int addRecord(Stock stock)
	{
		int rows_inserted = 0;
		Connection conn = openConnection();
		String INSERT_STOCK = "insert into stocks values(?,?,?,?,?)";
		PreparedStatement ps;
			
		try
		{
			ps = conn.prepareStatement(INSERT_STOCK);
			
			ps.setInt(1,stock.getFirmId());
			ps.setInt(2, stock.getSecurityId());
			ps.setFloat(3,stock.getHighestPrice());
			ps.setFloat(4, stock.getLowestPrice());
			ps.setFloat(5, stock.getLtp());
		
			rows_inserted = ps.executeUpdate();
			
			System.out.println("Rows : "+rows_inserted);
			//conn.close();	
			conn.setAutoCommit(true);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		
		return rows_inserted;		
	}
	
	@Override
	public Stock findStock(int firmId, int securityId)
	{
		Stock stock = new Stock(-1,-1,-1f,-1f,-1f);
		String FIND_STOCK = "select * from stocks where firm_id=? and security_id=?";
		
		Connection conn = openConnection();
		PreparedStatement ps;
		
		try
		{
			ps = conn.prepareStatement(FIND_STOCK);
			ps.setInt(1, firmId);
			ps.setInt(2, securityId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				float highestPrice = rs.getFloat(3);
				float lowestPrice = rs.getFloat(4);
				float ltp = rs.getFloat(5);
				
				stock.setFirmId(firmId);
				stock.setSecurityId(securityId);
				stock.setHighestPrice(highestPrice);
				stock.setLowestPrice(lowestPrice);
				stock.setLtp(ltp);
			}
			
			conn.setAutoCommit(true);

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return stock;
	}


	@Override
	public Stock deleteStock(int firmId, int securityId) 
	{
	String DELETE_STOCK = "delete from stocks where firm_id=? and security_id=?";
		
		Connection conn = openConnection();
		PreparedStatement ps;
		
		Stock stock = null;
		
		stock = findStock(firmId, securityId);
		
		if(stock!=null)
		{
			try
			{
				ps = conn.prepareStatement(DELETE_STOCK);
				ps.setInt(1, firmId);
				ps.setInt(2, securityId);
				ps.executeQuery();
				conn.setAutoCommit(true);
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}		
			
			return stock;
			
		}
		else
		{
			stock = new Stock(-1,-1,-1f,-1f,-1f);
			return stock;
		}	
		
		
	}

	
	
	@Override
	public boolean updateHighPrice(int firmId, int securityId)
	{
		boolean isUpdated = false;
		Connection conn = openConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new highest price: ");
		float highestPrice = sc.nextFloat();
		
		String UPDATE_STOCK = "update stocks set highest_price=? where firm_id=? and security_id=?";
		
		try
		{
			PreparedStatement ps = conn.prepareStatement(UPDATE_STOCK);
			ps.setFloat(1, highestPrice);
			ps.setInt(2, firmId);
			ps.setInt(3, securityId);
			
			int rows = ps.executeUpdate();
			conn.setAutoCommit(true);
			if(rows>0)
				isUpdated = true;
			else
				isUpdated = false;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		sc.close();
		return isUpdated;
	}

	@Override
	public boolean updateLowPrice(int firmId, int securityId) 
	{
		boolean isUpdated = false;
		Connection conn = openConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new lowest price: ");
		float lowestPrice = sc.nextFloat();
		
		String UPDATE_STOCK = "update stocks set lowest_price=? where firm_id=? and security_id=?";
		
		try
		{
			PreparedStatement ps = conn.prepareStatement(UPDATE_STOCK);
			ps.setFloat(1, lowestPrice);
			ps.setInt(2, firmId);
			ps.setInt(3, securityId);
			
			int rows = ps.executeUpdate();
			conn.setAutoCommit(true);
			if(rows>0)
				isUpdated = true;
			else
				isUpdated = false;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		sc.close();
		return isUpdated;
	}

	@Override
	public boolean updateLTP(int firmId, int securityId) 
	{
		boolean isUpdated = false;
		Connection conn = openConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new LTP: ");
		float ltp = sc.nextFloat();
		
		String UPDATE_STOCK = "update stocks set ltp=?  where firm_id=? and security_id=?";
		
		try
		{
			PreparedStatement ps = conn.prepareStatement(UPDATE_STOCK);
			ps.setFloat(1, ltp);
			ps.setInt(2, firmId);
			ps.setInt(3, securityId);
			
			int rows = ps.executeUpdate();
			conn.setAutoCommit(true);
			if(rows>0)
				isUpdated = true;
			else
				isUpdated = false;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		sc.close();
		return isUpdated;
	}

}
