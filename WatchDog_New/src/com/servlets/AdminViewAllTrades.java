package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojos.Trade;
import com.dao.TradeDAO;
import com.dao.TradeDAOImpl;

/**
 * Servlet implementation class AdminViewAllTrades
 */
@WebServlet("/adminViewAllTrades")
public class AdminViewAllTrades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewAllTrades() {
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
		
		allTrades = tdao.findAllTrades();
		System.out.println(allTrades.size());
		request.setAttribute("data", allTrades);
		RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
		dispatcher.forward(request, response);
	}

}
