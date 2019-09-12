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
		
		TraderDAOImpl tdao = new TraderDAOImpl();
		TradeDAOImpl tradedao = new TradeDAOImpl();
				
		
		int firmId=Integer.parseInt(request.getParameter("firmId"));
		int securityId=Integer.parseInt(request.getParameter("securityId"));
		int qty=Integer.parseInt(request.getParameter("qty"));
		float dealPrice = Float.parseFloat(request.getParameter("dealPrice"));
		String brokerId=request.getParameter("brokerId");
		Date date= new Date();
		long time = date.getTime();
		Timestamp timeStamp = new Timestamp(time);
		int tradeId = tradedao.getLastTradeID()+1;
		Trader t = new Trader();
		t=tdao.findByUsername(name);
		String tradeType=request.getParameter("tradeType");
		
		Trade trade = new Trade(tradeId, t, timeStamp, tradeType, securityId, qty, dealPrice, firmId, brokerId, 0);
		tradedao.addTrade(trade);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-index.html");
		dispatcher.forward(request, response);
		
	}

}
