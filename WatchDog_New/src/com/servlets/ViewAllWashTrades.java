	package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TradeDAO;
import com.dao.TradeDAOImpl;
import com.pojos.Algorithm;
import com.pojos.Trade;

/**
 * Servlet implementation class ViewAllWashTrades
 */
@WebServlet("/viewAllWashTrades")
public class ViewAllWashTrades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllWashTrades() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//TradeDAO tdao = new TradeDAOImpl();
		Algorithm algorithm= new Algorithm();
	    Set<Set<Trade>> washTradeSet = new HashSet<Set<Trade>>();

		
		washTradeSet = algorithm.RunAlgo();
		
		//CHANGE THE NAME OF THE VARIABLE AND DELETE COMMENT
		request.setAttribute("data",washTradeSet);
		
		//CHANGE THE NAME OF THE TARGET PAGE AND DELETE COMMENT
		RequestDispatcher dispatcher = request.getRequestDispatcher("page.html");
		dispatcher.forward(request, response);
	}

}
