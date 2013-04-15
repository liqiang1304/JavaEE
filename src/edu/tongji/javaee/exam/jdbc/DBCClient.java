package edu.tongji.javaee.exam.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBCClient extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DBCClient() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	
	public void viewByStatement(Connection conn,HttpServletResponse response){
        try{
			//3.Creating a statement
			Statement stmt = conn.createStatement();
			//4 Dispaly customer table 
			String sqlStat = "SELECT * FROM CUSTOMER";
			ResultSet result = stmt.executeQuery(sqlStat);
			//5.generate the HTTP Output document
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out = response.getWriter();
			out.println(
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD "
					+ "HTML 4.0 Transitional//EN\">");
			out.println("<HTML><HEAD><TITLE>JDBC Result Display</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<H1><center>This is A Example of DB2 JDBCDriver</H1><br>");
			out.println("<table border=\"1\"> width=\"200\"");
			out.println("<tr>");
			out.println("<th>USER</th><th>PASSWORD</th><th>NAME</th>");
			out.println("</tr>");
			while (result.next()) {
				String user = result.getString("username");
				String password = result.getString("password");
				String name = result.getString("fname");
				out.println("<tr>");
				if(user.equals(null)) user="N/A";
				if(password.equals(null)) password="N/A";
				if(name.equals(null)) name="N/A";
				out.println("<td>"+user+"</td>"+"<td>"+password+"</td>"+"<td>"+name+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</BODY></HTML>");
			//6 close jdbc
			result.close();
			stmt.close();
		} catch (SQLException se) {
			System.out.println(se);
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
   }
	
	public void insertByPreparedStatement(Connection conn) {
		try {
			//4.Executing insert SQL
			String insertSQL =
				"INSERT INTO CUSTOMER (username,fname,lname,password,email) VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(insertSQL);
			ps.setString(1, "zhang");
			ps.setString(2, "ZHANGSAN");
			ps.setString(3, "");
			ps.setString(4, "zhang11");
			ps.setString(5, "zs@163.com");
			if (ps.executeUpdate() == 1) {
				//4.1 if insert is successful, commit 
				conn.commit();
			}
			//6 close Statement
			ps.close();
		} catch (SQLException se) {
			System.out.println(se);
		}
	}
	
	public void viewDriver(HttpServletResponse response)
		throws ServletException, IOException
	{

	
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//2.Creating a connection
		   try{
			Connection conn =
						DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/exam",
							"root",
							"tongji");
			//5 delete a customer
			//deleteByStatement(conn);
			//insertByStatement(conn);
			//insertByPreparedStatement(conn);
		  //3.1 Display table contents
		    viewByStatement(conn,response);
				conn.close();
		    }catch(SQLException sqle){
		        System.out.println(sqle);
		    }
/*		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();*/
	}
	
    public void deleteByStatement(Connection conn){
		try {
			//3.Creating a statement
			Statement stmt = conn.createStatement();
			//4.Executing delete SQL
			String deleteSQL =
				"DELETE FROM CUSTOMER WHERE 	username='zhang'";
			if (stmt.executeUpdate(deleteSQL) == 1) {
				//4.1 if insert is successful, commit 
				conn.commit();
			}
			//6 close Statement
			stmt.close();
		} catch (SQLException se) {
			System.out.println(se);
		}
   }

	public void insertByStatement(Connection conn){ 
		try {
			//3.Creating a statement
			Statement stmt = conn.createStatement();
			//4.Executing insert SQL
			String insertSQL =
				"INSERT INTO CUSTOMER (username,fname,lname,password,email) VALUES ('zhang','ÕÅÈý','','zhang11','zs@163.com')";
			if (stmt.executeUpdate(insertSQL) == 1) {
				//4.1 if insert is successful, commit 
				conn.commit();
			}
			//6 close Statement
			stmt.close();
		} catch (SQLException se) {
			System.out.println(se);
		}
       }
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
/*		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();*/
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		//1.Loading a DB2 driver
	      try {
	    	  Class.forName("com.mysql.jdbc.Driver");
	      } catch (ClassNotFoundException cnfe) {
	    	  System.out.println(cnfe);
	      }
	}

}
