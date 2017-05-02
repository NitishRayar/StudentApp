package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AllStudentsView extends HttpServlet 
{
	RequestDispatcher dispatcher = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		/*
		 * II. Validate the Session
		 */
		HttpSession session = req.getSession(false);
		if(session==null)
		{
			//Invalid Session; Generate Login Page
			out.print("<font color=\"red\">");
			out.println("In-Valid Session !!! Pls Login ...");
			out.print("</font>");
			out.print("<BR><BR>");
			dispatcher = req.getRequestDispatcher("Login.html");
			dispatcher.include(req, resp);
			
		}else{
			//Valid Session; Generate Proper Response
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			try 
			{
				// 1. Load the Driver
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				// 2. Get the DB Connection via Driver
				String dbUrl = "jdbc:mysql://localhost:3306/becm10?user=j2ee&password=j2ee";
				con = DriverManager.getConnection(dbUrl);

				// 3. Issue SQL Queries via Connection
				String query = " select * from " + " student si, "
						+ " gaurdianinfo gi, " + " student_otherinfo soi "
						+ " where si.regno = gi.regno "
						+ " and si.regno = soi.regno ";

				System.out.println("Query : " + query);

				stmt = con.createStatement();

				rs = stmt.executeQuery(query);

				dispatcher = req.getRequestDispatcher("Header.html");
				dispatcher.include(req, resp);

				out.println("<html> ");
				out.println("<body> ");
				out.println("<table>");
				out.println("<tr bgcolor=\"green\">");
				out.println("<td>Reg. No.</td>     ");
				out.println("<td>First Name</td>   ");
				out.println("<td>Last Name</td>    ");
				out.println("<td>G First Name</td> ");
				out.println("<td>G Last Name</td>  ");
				out.println("</tr>");
				while (rs.next()) {
					int regnum = rs.getInt("regno");
					String fNM = rs.getString("fname");
					String lNM = rs.getString("lname");
					String gfNM = rs.getString("gi.gfname");
					String glNM = rs.getString("gi.lname");
					String isAdmin = rs.getString("soi.isAdmin");

					out.println("<tr> ");
					out.println("<td>" + regnum + "</td>  ");
					out.println("<td>" + fNM + "</td>");
					out.println("<td>" + lNM + "</td>");
					out.println("<td>" + gfNM + "</td>");
					out.println("<td>" + glNM + "</td>");
					out.println("</tr> ");

				}
				out.println("</table>    ");
				out.println("</body>     ");
				out.println("</html> ");
/*
				dispatcher = req.getRequestDispatcher("Footer.html");
				dispatcher.include(req, resp);
*/				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}
