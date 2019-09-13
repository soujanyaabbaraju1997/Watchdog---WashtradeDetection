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
 * Servlet implementation class ViewAllWashTradeSet
 */
@WebServlet("/viewallwashtradeset")
public class ViewAllWashTradeSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllWashTradeSet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TradeDAO tdao = new TradeDAOImpl();
		List<Trade> washTrades = new ArrayList<Trade>();
		
		washTrades = tdao.findWashTrades();
		
		//CHANGE THE NAME OF THE VARIABLE AND DELETE COMMENT
		request.setAttribute("data",washTrades);
		
		//CHANGE THE NAME OF THE TARGET PAGE AND DELETE COMMENT
		RequestDispatcher dispatcher = request.getRequestDispatcher("wash-trades.jsp");
		dispatcher.forward(request, response);
	}

}
