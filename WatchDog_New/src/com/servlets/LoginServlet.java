package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDAO;
import com.dao.UserDAO;
import com.dao.UserDAOImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//doGet(request, response);
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserDAO userdao = new UserDAOImpl();
		
		int isadmin=userdao.findUserByUsername(username).isAdmin();
		
		
		LoginDAO dao = new LoginDAO();
		
		String name=dao.dologin(username,password);
		System.out.println("username "+name);
		
		if(name.equals("no_user"))
		{
			request.setAttribute("msg", "Credentials do not match.Try again");
			
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			HttpSession httpsession =request.getSession();
			System.out.println(httpsession.getId()+": "
					+httpsession.getCreationTime());
			httpsession.setAttribute("username", name);		
			if(isadmin==1)
			{
				RequestDispatcher rd=request.getRequestDispatcher("admin.html");
				rd.forward(request, response);
					//
				
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("trader.html");
				rd.forward(request, response);

			}
			
			
		}
		//return name;
	}

		
	

}
