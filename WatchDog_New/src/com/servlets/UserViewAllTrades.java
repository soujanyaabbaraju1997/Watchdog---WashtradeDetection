package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TradeDAO;
import com.dao.TradeDAOImpl;
import com.pojos.Trade;

/**
 * Servlet implementation class UserViewAllTrades
 */
@WebServlet("/userViewAllTrades")
public class UserViewAllTrades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserViewAllTrades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		TradeDAO tdao = new TradeDAOImpl(); 
		List<Trade> allTrades = new ArrayList<Trade>();
		String traderId=request.getParameter("traderId");
		allTrades = tdao.findByTraderId(traderId);
		
		//VERIFY THE NAME OF REQUEST ATTRIBUTE.
		request.setAttribute("data", allTrades);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-index.html");
		dispatcher.forward(request, response);
	}

}
