package com.servlets;
import com.database.randomstring;
import com.pojos.Trader;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
//import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TraderDAO;
import com.dao.TraderDAOImpl;
import com.database.randomstring;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException
	{
		String traderName=request.getParameter("traderName");
		System.out.println(request.getParameter("traderName"));
		String emailId=request.getParameter("emailId");
		System.out.println(request.getParameter("emailId"));
		String username=request.getParameter("username");
		System.out.println(request.getParameter("username"));
		
		
		String password=request.getParameter("password");
		System.out.println(request.getParameter("password"));
		String confirmPassword = request.getParameter("cnf_password");	
		System.out.println(request.getParameter("cnf_password"));
		
		
		long phone= Long.parseLong(request.getParameter("phone"));
		System.out.println(request.getParameter("phone"));
		

		String dobstring = request.getParameter("dob");
		int dob_yr = Integer.parseInt(dobstring.substring(6,10));
		System.out.println(dob_yr);
		int dob_mth = Integer.parseInt(dobstring.substring(0,2));
		System.out.println(dob_mth);
		int dob_dt = Integer.parseInt(dobstring.substring(3,5));
		System.out.println(dob_dt);
		Date dob = new Date(dob_yr, dob_mth, dob_dt);
		
		String traderId = username.substring(0, 3).toUpperCase()+randomstring.getAlphaNumericString(5);
		java.sql.Date dateReg = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		System.out.println(dateReg);
		
		
		System.out.println(request.getParameter("traderName"));
		System.out.println(phone);
		//System.out.println(dateReg);
		
//		
		if(password.equals(confirmPassword))
		{
			Trader trader = new Trader(traderId, traderName, dateReg, username, password, emailId, phone, dob);
			TraderDAO dao = new TraderDAOImpl();
			int inserted = dao.addTrader(trader);
			
			if(inserted==0)
			{
				request.setAttribute("msg", "Something Went Wrong. Please try again");
				
				RequestDispatcher rd=request.getRequestDispatcher("register.html");
				rd.forward(request, response);
				
			}
			else
			{
				HttpSession httpsession =request.getSession();
				System.out.println(httpsession.getId()+": "
						+httpsession.getCreationTime());	
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.forward(request, response);
				
			}
			
		}
		else
		{
			request.setAttribute("msg", "Passwords do not match.");
			
			RequestDispatcher rd=request.getRequestDispatcher("register.html");
			rd.forward(request, response);
		}
		
	}
//		
	

}
