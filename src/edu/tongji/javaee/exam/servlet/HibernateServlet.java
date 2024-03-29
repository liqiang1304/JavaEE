package edu.tongji.javaee.exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

import org.hibernate.Query;

import antlr.collections.List;

import edu.tongji.hibernate.HibernateSessionFactory;
import edu.tongji.javaee.exam.model.TestArea;

public class HibernateServlet extends HttpServlet {

	public void execute(HttpServletResponse response, HttpServletRequest request)
	throws ServletException, IOException{
		
	}
	
	
	
	
	
	
	/**
	 * Constructor of the object.
	 */
	public HibernateServlet() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//insertBySession();
		org.hibernate.Session session=HibernateSessionFactory.getSession();
		//TestArea area=(TestArea)session.load(TestArea.class, 1);
		Query query = session.createQuery("from TestArea as m where m.key>?");
		query.setInteger(0, 4);
		java.util.List  list=query.list();
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("ID TestArea Description<br/>");
		Iterator it=list.iterator();
		while(it.hasNext()){
			TestArea area=(TestArea)it.next();
			out.println(area.getKey()+"--"+area.getTestArea()+"--"+area.getDescription()+"<br/>");
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void insertBySession(){
		org.hibernate.Session session=HibernateSessionFactory.getSession();
		TestArea newArea=new TestArea();
		newArea.setKey(8);
		newArea.setTestArea("Web2.0");
		newArea.setDescription("Develop Web2.0");
		newArea.setImageFile("Web2.jpg");
		org.hibernate.Transaction trans=session.beginTransaction();
		session.save(newArea);
		trans.commit();
		session.flush();
		session.close();
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

		response.setContentType("text/html");
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
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
