package com.jc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.jc.dao.ContactDao;
import com.jc.pojo.Contact;
import com.jc.pojo.Request;

/**
 * Servlet implementation class ShowContact
 */
public class ShowContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactDao asi=new ContactDao ();

		ArrayList<Contact> al = asi.getAllContact();
		 ObjectMapper objectMapper = new ObjectMapper();
		 try
		 {
			 response.setContentType("text/html");
			 PrintWriter out = response.getWriter();
			  out.print("<html>");
			  out.print("<link href='css/bootstrap.min.css' rel='stylesheet' /> <link href='plugins/flexslider/flexslider.css' rel='stylesheet' media='screen' />	<link href='css/cubeportfolio.min.css' rel='stylesheet' /><link href='css/style.css' rel='stylesheet' /><link id='t-colors' href='skins/default.css' rel='stylesheet' /><link id='bodybg' href='bodybg/bg1.css' rel='stylesheet' type='text/css' />");

			  out.print("<body>");
			  out.print("<img src='img/logo.jpg' alt='' width='100' height='100' /> ");

			  out.print("<h1> All Submitted Contacts Request</h1>");
			  out.print("<hr class='colorgraph'>");

			  out.print("<table class='table table-hover'>");
			  out.print("<tr>");
			  out.print("<th> Name");
			  out.print("<th> Email Id");
			  out.print("<th> Message");
			 for(int i=0;i<al.size();i++)
			 {
				 
				 //String writingJson=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(al.get(i));
				 
				 if(i%2==0)
				 {
					 out.print("<tr class='active'>");
				 }
				 else{
				 out.print("<tr class='warning'>");}
				 out.print("<td>"+al.get(i).getName());
				 
				
				 
				 
				 
				 out.print("<td>"+al.get(i).getEmailId());
				 
			
				 out.print("<td>"+al.get(i).getMsg());
				 
				 //out.print("<td><a href='DeleteServlet'>Delete</a>");

			       /*if(i==al.size()-1)
			       {
			        out.print(writingJson);
			        break;
			       }
			       out.print(writingJson+",");*/
			 
			 }
			  out.print("</table>");
			  out.print("<hr class='colorgraph'>");
				 out.print("<a href='http://jctechnology.in/index.html/index.html'> Go To Home</a>");
			  out.print("</body>");
			  out.print("</HTML>");
			 
		 }
			 catch(Exception e)
			 {
				 System.out.println("Exception Occured");
				 
			 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
