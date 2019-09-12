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

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "group8", "trade");
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
		
		String INSERT_STOCK = "insert into stocks values(?,?,?,?,?)";
		String FIRM_ID_EXISTENCE = "select firm_id from firms where firm_id = ?";
		String SECURITY_ID_EXISTENCE = "select security_id from securities where security_id = ?";
		String LP_DP_HP = "Deal price error";
		
		try(Connection conn1 = openConnection();PreparedStatement ps1 = conn1.prepareStatement(FIRM_ID_EXISTENCE);PreparedStatement ps2 = conn1.prepareStatement(SECURITY_ID_EXISTENCE))
		{
			ps1.setInt(1, stock.getFirmId());
			ResultSet rs1=ps1.executeQuery();
			ps2.setInt(1, stock.getSecurityId());
			ResultSet rs2=ps2.executeQuery();
			
			String firmNonExist= "Firm doesn't exist. ";
			String securityNonExist= "Security doesn't exist. ";
			
			System.out.println(rs1);
			System.out.println(rs2);
			int i=0, j=0;
			
			 while(rs1.next())
			 {
				 i++;
			 }
			 while(rs2.next())
			 {
				 j++;
			 }
			 if(i==0 || j==0)
			 {
				 System.out.println(securityNonExist + "OR" + firmNonExist);
				 
			 }
			 
			 else
			 {
				 if(stock.getLtp()<stock.getHighestPrice() && stock.getLtp()>stock.getLowestPrice())
				 {

						try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(INSERT_STOCK);)
						{			
							ps.setInt(1,stock.getFirmId());
							ps.setInt(2, stock.getSecurityId());
							ps.setFloat(3,stock.getHighestPrice());
							ps.setFloat(4, stock.getLowestPrice());
							ps.setFloat(5, stock.getLtp());
						
							rows_inserted = ps.executeUpdate();
							conn.setAutoCommit(true);
						}
						catch (SQLException e) 
						{
							e.printStackTrace();
						}	
				 }
				 else
				 {	
					System.out.println(LP_DP_HP);
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
	public Stock findStock(int firmId, int securityId)
	{
		Stock stock = new Stock(-1,-1,-1f,-1f,-1f);
		String FIND_STOCK = "select * from stocks where firm_id=? and security_id=?";
			
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(FIND_STOCK);)
		{
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
		
		Stock stock = null;
		
		stock = findStock(firmId, securityId);
		
		if(stock!=null)
		{
			try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(DELETE_STOCK);)
			{
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

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new highest price: ");
		float highestPrice = sc.nextFloat();
		
		String UPDATE_STOCK = "update stocks set highest_price=? where firm_id=? and security_id=?";
		
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(UPDATE_STOCK);)
		{
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
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new lowest price: ");
		float lowestPrice = sc.nextFloat();
		
		String UPDATE_STOCK = "update stocks set lowest_price=? where firm_id=? and security_id=?";
		
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(UPDATE_STOCK);)
		{
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

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new LTP: ");
		float ltp = sc.nextFloat();
		
		String UPDATE_STOCK = "update stocks set ltp=?  where firm_id=? and security_id=?";
		
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(UPDATE_STOCK);)
		{
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
