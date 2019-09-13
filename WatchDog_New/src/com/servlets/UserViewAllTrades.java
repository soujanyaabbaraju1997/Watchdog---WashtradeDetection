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
import javax.servlet.http.HttpSession;

import com.dao.LoginDAO;
import com.dao.TradeDAO;
import com.dao.TradeDAOImpl;
import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.pojos.Trade;

/**
 * Servlet implementation class UserViewAllTrades
 */
@WebServlet("/UserViewAllTrades")
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TradeDAO tdao = new TradeDAOImpl(); 
		List<Trade> allTrades = new ArrayList<Trade>();
		
		allTrades = tdao.findAllTrades();
		System.out.println(allTrades.size());
		request.setAttribute("listOfTradesForUser", allTrades);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-index.jsp");
		dispatcher.forward(request, response);
	}

}
