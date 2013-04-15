package edu.tongji.javaee.exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.tongji.javaee.exam.model.Customer;

public class LoginServiceServlet extends HttpServlet {

	
/*	  private static String customerList[] = { "bones", "baddog", "meow",
	  "scout" }; private static String passwordList[] = { "ZG9n", "ZG9n",
	  "Y2F0", "ZG9n" }; private static String nameList[] = { "Goldie",
	  "Shadow", "Typsie", "Gary" };*/
	 

	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String password = request.getParameter("PWD1");
		boolean login = false; //login flag
		String title = "Login Error";
		String message = "Sorry! Login Fail";
		String reason = "Invalid User";
/*		for (int i = 0; i < customerList.length; i++) {
			if (username.equals(customerList[i])) {
				if (password.equals(passwordList[i])) {
					login = true;
					reason = nameList[i];
				} else
					reason = "Invalid password!";
				break;
			}
		}*/
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/exam",
						"root",
						"tongji");
			//3.Creating a statement
			Statement stmt = conn.createStatement();
			String sqlStat = "SELECT * FROM CUSTOMER WHERE USERNAME='" + username + "'";
			//4.Executing SQL
			ResultSet result = stmt.executeQuery(sqlStat);
			//5. Processing ResultSet
			if (result.next()) {
				String passwd = result.getString("password");
				if (password.equals(passwd)) {
					login = true;
					reason = result.getString("fname");
					 //6 pssword error
				} else {
					reason = "Password Error~using sql.";
					this.display(response, title, message, reason);
				}
			}
				result.close();
				stmt.close();
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		if (login) {
			/**
			 * 通过验证--课堂作业1
			 **/
			Customer cust=new Customer();
			cust.setUsername(username);
			cust.setPassword(password);
			cust.setFirstName(reason);
			request.setAttribute("customer", cust);
			request.getRequestDispatcher("/JSP/exam_logon_success.jsp").forward(request, response);
			//message = "Welcome! Login Success";
     		//this.display(response, title, message, reason);
		} else {
			this.display(response, title, message, reason);
		}

		
	}

	private void display(HttpServletResponse response, String title,
			String message, String reason) {
		try {
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD "
					+ "HTML 4.0 Transitional//EN\">");
			out.println("<HTML><HEAD><TITLE>" + title + "</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<H1>" + message
					+ "</H1><br><font color='red' face='宋体'>" + reason
					+ "</font>");
			out.println("</BODY></HTML>");
		} catch (Throwable e) {
		}
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
		/*
		 * response.setContentType("text/html"); PrintWriter out =
		 * response.getWriter(); out.println(
		 * "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		 * out.println("<HTML>");
		 * out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		 * out.println("  <BODY>"); out.print("    This is ");
		 * out.print(this.getClass()); out.println(", using the GET method");
		 * out.println("  </BODY>"); out.println("</HTML>"); out.flush();
		 * out.close();
		 */
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
		/*
		 * response.setContentType("text/html"); PrintWriter out =
		 * response.getWriter(); out.println(
		 * "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		 * out.println("<HTML>");
		 * out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		 * out.println("  <BODY>"); out.print("    This is ");
		 * out.print(this.getClass()); out.println(", using the POST method");
		 * out.println("  </BODY>"); out.println("</HTML>"); out.flush();
		 * out.close();
		 */
	}

}
