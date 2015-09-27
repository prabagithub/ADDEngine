package com.add.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.add.db.MongoDBDAO;
import com.add.domain.User;

/**
 * Servlet implementation class LoginServlet
 */
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		RequestDispatcher rd = null;
		String viewName = "/login.jsp";
		try{			
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("pwd"));
		String register = request.getParameter("register");
		MongoDBDAO mongo = new MongoDBDAO();
		if(null != register && register.equalsIgnoreCase("register")){
			if(mongo.checkUser(user)){
				viewName="/register.jsp";
			}else{
				mongo.registerUser(user);
				viewName="/home.jsp";
			}
			
		}else{
			if(mongo.checkUser(user)){
				viewName="/home.jsp";
			}
			
		}
		request.setAttribute("username", user.getUsername());			
		rd = request.getRequestDispatcher(viewName);
		} catch(Exception e){			
			rd = request.getRequestDispatcher(viewName);
		}
		if(viewName.equalsIgnoreCase("/login.jsp") || viewName.equalsIgnoreCase("/register.jsp")){
			request.setAttribute("error", true);
		}
		rd.forward(request, response);
		
				
		
		
	}

}
