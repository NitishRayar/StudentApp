<%!
	private int age = 100;
	public String name = "Rajani Kanth"; 

	public int getAge(){
		return age;
	}

	public String getName(){
		return name;
	}
	
	public String getName(String givenNM){
		return "Given Name is - "+givenNM;
	}
%>

<html>
<body>
	<h1>JSP Tags Example ....</h1>
	<BR><BR>
	Name : <%= name %>
	<BR>
	Age : <%= age %>
	
	<BR><BR>
	Name 1: <%= getName() %>
	<BR>
	Name 2: <%= getName("Praveen D") %>
	<BR>
	Name 3: <%= getName(name+"Praveen D "+getName()) %>
	<BR>
	Age 2 : <%= getAge() %>
	<BR><BR>
	
	<%
		int j = 200;
		for(int i=0;i<5;i++)
		{
	%>
			Name : <%= name %>
			<BR>
	<%
		}
	%>	
	
</body>
</html>









