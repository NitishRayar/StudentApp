<%@page import="java.util.Date"%>

<%!
	public void jspInit(){
		System.out.println("Inside jspInit() ....");
	}
	
	public void jspDestroy(){
		System.out.println("Inside jspDestroy() ....");
	}
%>


<%
	System.out.println("Inside _jspService ....");

	//Java Code to Generate Current Date & Time
	Date dateRef = new Date();
	String currDate = dateRef.toString();
	
	//Get the Query String Info
	String fNM = request.getParameter("fname");
	String lNM = request.getParameter("lname");
%>

<html>
<body>
	<h1>
		<!-- HTML Comment -->
		<%-- JSP Comment --%>
		Current Date & Time is :
		<BR>
		<font color="green">
			<%= currDate %>
		</font>
		<BR><BR>
		First Name : <%= fNM %>
		<BR>
		Last Name : <%= lNM %>
	</h1>
</body>
</html>



