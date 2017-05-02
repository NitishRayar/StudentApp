package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet
{ 
	@Override
	protected void doGet(HttpServletRequest req, 
			             HttpServletResponse resp)
	throws ServletException, IOException 
	{ 
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//Get the ServletContext Object
		ServletContext context = getServletContext();
		Object obj = context.getAttribute("contextKey");
		
		if(obj==null)
		{
			out.print(" ServletContext Attribute NOT Present !!!");
		}else{
			out.print(" ServletContext Attribute Present ....");
			String val = obj.toString();
			out.print(" Object Value : "+val);
		}
		
		Object obj2 = req.getAttribute("reqKey");
		if(obj2==null)
		{
			out.print(" ServletRequest Attribute NOT Present !!!");
		}else{
			out.print(" ServletRequest Attribute Present ....");
			String val = (String)obj2;
			out.print(" Value : "+val);
		}
		
		
		
		
		
	}//End of doGet
}//End of Class








