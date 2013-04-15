<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="customer" class="edu.tongji.javaee.exam.model.Customer"
	scope="request"></jsp:useBean>
<jsp:setProperty name="customer" property="username" param="username" />
<jsp:setProperty name="customer" property="password" param="PWD1" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
<%!
	private static String customerList[] = { "bones", "baddog", "meow", "scout" };
	private static String passwordList[] = { "ZG9n", "ZG9n", "Y2F0", "ZG9n" };
	private static String nameList[] = { "Goldie", "Shadow", "Typsie", "Gary" };
%>
<META http-equiv="Content-Type" content="text/html; charset=GB2312">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>checkLogin.jsp</TITLE>
    <base href="<%=basePath%>">
    
    <title>My JSP 'LoginService.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%
			//String username = request.getParameter("username");
			//String password = request.getParameter("PWD1").trim();
			boolean login = false; //login flag
			String title = "Login Error";
			String message = "Sorry！Login Fail";
			String reason = "Invalid User";
			//Step3: Check Request Data
			
			for (int i = 0; i < customerList.length; i++) {
				if (customer.getUsername().equals(customerList[i])) {
					if (customer.getPassword().equals(passwordList[i])) {
						login = true;
						reason = nameList[i];
					} else
						reason = "Invalid password!";
					break;
				}
			}
			//Step 4 output dynamic content
			if (login) {
	%>
	<jsp:setProperty name="customer" property="firstName" value="<%=reason%>" />
	<jsp:forward page="JSP/exam_logon_success.jsp"></jsp:forward>
	<H1>Welcome! Login Success</H1><br>
   		  <%  }else{ %>
<H1>Sorry! Login Fail</H1><br>
     <%  } %>
	<font color='red' face='宋体'><%=reason%></font>
    This is my JSP page. <br>
  </body>
</html>
