package edu.tongji;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CGIServlet extends HttpServlet {
	private static int cnt=0;
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY  bgcolor=\"rgb(0,128,192)\">");
		out.println("<h1 align=\"center\">This is My first web</h1>");
		out.println("<hr />");
		/*if(in.equals("Lee")&&pass.equals("1234")){
			out.println("<h1 align=\"center\"><font color=\"green\">Login Success!</font></h1>");
		}else{
			out.println("<h1 align=\"center\"><font color=\"red\">Password or username Error!!!</font></h1>");
		}*/
		out.print(" <p>This is ");
		out.print(this.getClass());
		out.println(", using the GET method</br>");
		out.println("Counter: "+cnt++);
		//out.println("</br>your Password="+in+"</p>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		String in=request.getParameter("input");
		String pass=request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY  bgcolor=\"rgb(0,128,192)\">");
		out.println("<h1 align=\"center\">This is My first web</h1>");
		out.println("<hr />");
		if(in.equals("Lee")&&pass.equals("1234")){
			out.println("<h1 align=\"center\"><font color=\"green\">Login Success!</font></h1>");
		}else{
			out.println("<h1 align=\"center\"><font color=\"red\">Password or username Error!!!</font></h1>");
		}
		out.print(" <p>This is ");
		out.print(this.getClass());
		out.println(", using the GET method</br>");
		out.println("Counter: "+cnt++);
		out.println("</br>your Password="+in+"</p>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
