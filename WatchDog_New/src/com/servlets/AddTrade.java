package com.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TradeDAO;
import com.dao.TradeDAOImpl;
import com.pojos.Trader;

/**
 * Servlet implementation class AddTrade
 */
@WebServlet("/addTrade")
public class AddTrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTrade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		TradeDAO tdao = new TradeDAOImpl();
		
		String tradeType=request.getParameter("tradeType");
		int firmId=Integer.parseInt(request.getParameter("firmId"));
		int securityId=Integer.parseInt(request.getParameter("securityId"));
		int qty=Integer.parseInt(request.getParameter("qty"));
		float dealPrice = Float.parseFloat(request.getParameter("dealPrice"));
		
		Date date= new Date();
		long time = date.getTime();
		Timestamp timeStamp = new Timestamp(time);
		
		int tradeId = tdao.getLastTradeID()+1;
		
		
	}

}
