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

import com.dao.TradeDAO;
import com.dao.TradeDAOImpl;
import com.dao.TraderDAO;
import com.dao.TraderDAOImpl;
import com.pojos.Trade;
import com.pojos.Trader;

/**
 * Servlet implementation class ViewTradesForTraderId
 */
@WebServlet("/viewtradesfortradeid")
public class ViewTradesForTraderId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTradesForTraderId() {
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
		
		HttpSession httpsession =request.getSession();
		String name;
		name=(String) httpsession.getAttribute("username");
		TraderDAOImpl tdao = new TraderDAOImpl();
		TradeDAOImpl tradedao = new TradeDAOImpl();
		Trader t = new Trader();
		t=tdao.findByUsername(name);
		List <Trade> tradelist= new ArrayList<Trade>();
		tradelist=tradedao.findByTraderId(t.getTraderId());
		
		
		request.setAttribute("data",tradelist);
		
		//CHANGE THE NAME OF THE TARGET PAGE AND DELETE COMMENT
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-index.html");
		dispatcher.forward(request, response);

		
		//doGet(request, response);
	}

}
