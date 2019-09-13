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
 * Servlet implementation class ViewAllForTrader
 */
@WebServlet("/ViewAllForTrader")
public class ViewAllForTrader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllForTrader() {
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
		
		TraderDAO tdao = new TraderDAOImpl();
		TradeDAO tradedao = new TradeDAOImpl();
		
		Trader t = new Trader();
		t=tdao.findByUsername(name);
		System.out.println(t);
		
		List <Trade> tradelist= new ArrayList<Trade>();
		tradelist=tradedao.findByTraderId(t.getTraderId());
				
		request.setAttribute("data",tradelist);
		System.out.println(tradelist.size());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-index.jsp");
		dispatcher.forward(request, response);
	}

}
