package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookieServlet extends HttpServlet
{ 
	@Override
	protected void doGet(HttpServletRequest req, 
			             HttpServletResponse resp)
	throws ServletException, IOException 
	{ 
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//Get the Cookies From Request
		Cookie[] receviedCookies = req.getCookies();
		
		if(receviedCookies==null)
		{
			out.print("Cookies are NOT Present !!!");
		}else{
			out.print("Cookies are Present ...");
			for(Cookie rcvdCookie : receviedCookies)
			{
				String name = rcvdCookie.getName();
				if(name.equals("myLocation"))
				{
				   rcvdCookie.setMaxAge(0);
				   resp.addCookie(rcvdCookie);
				   out.print("Deleted 'myLocation' Cookie");
				   break;
				}
			   
			}
		}
	}//End of doGet
}//End of Class








