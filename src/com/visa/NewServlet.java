package com.visa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/home")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("name");
		String password= req.getParameter("password");
		
		PrintWriter out=resp.getWriter();
		if(name !=null && name.equals("manish") && password.equals("abc"))	
		{
		out.printf("Welcome %s",name);
		Cookie nameCookie=new Cookie("name",name);
		Cookie passCookie=new Cookie("name",password);
		nameCookie.setMaxAge(60*60*24); 
	      passCookie.setMaxAge(60*60*24); 
		resp.addCookie(nameCookie);
		resp.addCookie(passCookie);
        		
		
		}
		else
			out.println("Invalid credentials!");
		
	}


}
