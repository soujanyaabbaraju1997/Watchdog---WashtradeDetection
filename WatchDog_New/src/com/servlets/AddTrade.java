package com.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TradeDAO;
import com.dao.TradeDAOImpl;
import com.dao.TraderDAOImpl;
import com.pojos.Trade;
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
		HttpSession httpsession =request.getSession();
		String name;
		name=(String) httpsession.getAttribute("username");
		System.out.println(name);
		
		String tradeType=request.getParameter("tradeType");
		System.out.println(tradeType);
		
		int firmId=Integer.parseInt(request.getParameter("firmId"));
		System.out.println(firmId);
		
		int securityId=Integer.parseInt(request.getParameter("securityId"));
		System.out.println(securityId);
		
		String brokerId=request.getParameter("brokerId");
		System.out.println(brokerId);
		
		int qty=Integer.parseInt(request.getParameter("qty"));
		System.out.println(qty);
		
		float dealPrice = Float.parseFloat(request.getParameter("dealPrice"));
		System.out.println(dealPrice);
		
		Date date= new Date();
		long time = date.getTime();
		Timestamp timeStamp = new Timestamp(time);
		System.out.println(timeStamp);
		
		TraderDAOImpl tdao = new TraderDAOImpl();
		TradeDAOImpl tradedao = new TradeDAOImpl();
		
		int tradeId = tradedao.getLastTradeID()+1;
		System.out.println(tradeId);
		
		Trader t = new Trader();
		t=tdao.findByUsername(name);	
		
		Trade trade = new Trade(tradeId, t, timeStamp, tradeType, securityId, qty, dealPrice, firmId, brokerId, 0);
		int add = tradedao.addTrade(trade);
		System.out.println(add);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-index.html");
		dispatcher.forward(request, response);
		
		//
	}

}
