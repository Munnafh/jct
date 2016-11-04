package com.jc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jc.dao.ContactDao;
import com.jc.pojo.Request;

/**
 * Servlet implementation class LogInServlet
 */
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactDao asi=new ContactDao ();
		try {
			if(asi.adminLogIn(request.getParameter("un"), request.getParameter("pwd"))){
				 response.setContentType("text/html");
				/* PrintWriter out = response.getWriter();
				 out.print("<link href='css/bootstrap.min.css' rel='stylesheet' /> <link href='plugins/flexslider/flexslider.css' rel='stylesheet' media='screen' />	<link href='css/cubeportfolio.min.css' rel='stylesheet' /><link href='css/style.css' rel='stylesheet' /><link id='t-colors' href='skins/default.css' rel='stylesheet' /><link id='bodybg' href='bodybg/bg1.css' rel='stylesheet' type='text/css' />");
				 out.print("<a href='ShowRequest' class='btn btn-theme btn-lg'>");
				 out.print("All Request Details..");
				 out.print("</a>");*/
				 ArrayList<Request> al = asi.getAllRequest();
				 PrintWriter out = response.getWriter();
				  out.print("<html>");
				  out.print("<link href='css/bootstrap.min.css' rel='stylesheet' /> <link href='plugins/flexslider/flexslider.css' rel='stylesheet' media='screen' />	<link href='css/cubeportfolio.min.css' rel='stylesheet' /><link href='css/style.css' rel='stylesheet' /><link id='t-colors' href='skins/default.css' rel='stylesheet' /><link id='bodybg' href='bodybg/bg1.css' rel='stylesheet' type='text/css' />");

				  out.print("<body>");
				  out.print("<h1> All Submitted Requests</h1>");
				  out.print("<table class='table table-hover'>");
				  out.print("<tr>");
				  out.print("<th> Request_Id");
				  out.print("<th> Name");
				  out.print("<th> PhoneNo");
				  out.print("<th> Email Id");
				  out.print("<th> Message");
				  out.print("<th> Request_Date");
				 for(int i=0;i<al.size();i++)
				 {
					 
					 //String writingJson=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(al.get(i));
					 
					 if(i%2==0)
					 {
						 out.print("<tr class='active'>");
					 }
					 else{
					 out.print("<tr class='warning'>");}
					 out.print("<td>"+al.get(i).getId());
					 
					 out.print("<td>"+al.get(i).getName());
					 
					
					 out.print("<td>"+al.get(i).getPhoneNo());
					 
					 
					 out.print("<td>"+al.get(i).getEmailId());
					 
				
					 out.print("<td>"+al.get(i).getMsg());
					 
					 out.print("<td>"+al.get(i).getCreateDate());
					 
					 //out.print("<td><a href='DeleteServlet'>Delete</a>");

				       /*if(i==al.size()-1)
				       {
				        out.print(writingJson);
				        break;
				       }
				       out.print(writingJson+",");*/
				 
				 }
				  out.print("</table>");
				  out.print("</body>");
				  out.print("</HTML>");
				 
				 //response.sendRedirect("ShowRequest");
			}
			else
			{
				 response.setContentType("text/html");
				 PrintWriter out = response.getWriter();
				  out.print("<link href='css/bootstrap.min.css' rel='stylesheet' /> <link href='plugins/flexslider/flexslider.css' rel='stylesheet' media='screen' />	<link href='css/cubeportfolio.min.css' rel='stylesheet' /><link href='css/style.css' rel='stylesheet' /><link id='t-colors' href='skins/default.css' rel='stylesheet' /><link id='bodybg' href='bodybg/bg1.css' rel='stylesheet' type='text/css' />");
				  out.print("<img src='img/logo.jpg' alt='' width='100' height='100' /> ");
				 out.print("<h2>LogIn Failed.... Wrong Details....</h2>");
				 out.print("<a href='http://jctechnology.in/index.html'> Go To Home</a>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactDao asi=new ContactDao ();
		try {
			if(asi.adminLogIn(request.getParameter("un"), request.getParameter("pwd"))){
				 response.setContentType("text/html");
				/* PrintWriter out = response.getWriter();
				 out.print("<link href='css/bootstrap.min.css' rel='stylesheet' /> <link href='plugins/flexslider/flexslider.css' rel='stylesheet' media='screen' />	<link href='css/cubeportfolio.min.css' rel='stylesheet' /><link href='css/style.css' rel='stylesheet' /><link id='t-colors' href='skins/default.css' rel='stylesheet' /><link id='bodybg' href='bodybg/bg1.css' rel='stylesheet' type='text/css' />");
				 out.print("<a href='ShowRequest' class='btn btn-theme btn-lg'>");
				 out.print("All Request Details..");
				 out.print("</a>");*/
				 ArrayList<Request> al = asi.getAllRequest();
				 PrintWriter out = response.getWriter();
				  out.print("<html>");
				  out.print("<link href='css/bootstrap.min.css' rel='stylesheet' /> <link href='plugins/flexslider/flexslider.css' rel='stylesheet' media='screen' />	<link href='css/cubeportfolio.min.css' rel='stylesheet' /><link href='css/style.css' rel='stylesheet' /><link id='t-colors' href='skins/default.css' rel='stylesheet' /><link id='bodybg' href='bodybg/bg1.css' rel='stylesheet' type='text/css' />");

				  out.print("<body>");
				  out.print("<img src='img/logo.jpg' alt='' width='100' height='100' /> ");

				  out.print("<h1> All Submitted Requests</h1> <h3><a href='ShowContact'>See Contact Requests</a></h3>");
				  out.print("<hr class='colorgraph'>");

				  out.print("<br> <h4>Delete solved request .</h4> <form action='DelteRequest'> <h5> Requst No:</h5> <input type='text' name='no'> <input type='submit' value='Delete' class='btn btn-theme btn-lg'></form>");
				  out.print("<hr class='colorgraph'>");

				  out.print("<table class='table table-hover'>");
				  out.print("<tr>");
				  out.print("<th> Request_Id");
				  out.print("<th> Name");
				  out.print("<th> PhoneNo");
				  out.print("<th> Email Id");
				  out.print("<th> Message");
				  out.print("<th> Request_Date");
				 for(int i=0;i<al.size();i++)
				 {
					 
					 //String writingJson=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(al.get(i));
					 
					 if(i%2==0)
					 {
						 out.print("<tr class='active'>");
					 }
					 else{
					 out.print("<tr class='warning'>");}
					 out.print("<td>"+al.get(i).getId());
					 
					 out.print("<td>"+al.get(i).getName());
					 
					
					 out.print("<td>"+al.get(i).getPhoneNo());
					 
					 
					 out.print("<td>"+al.get(i).getEmailId());
					 
				
					 out.print("<td>"+al.get(i).getMsg());
					 
					 out.print("<td>"+al.get(i).getCreateDate());
					 
					 //out.print("<td><a href='DeleteServlet'>Delete</a>");

				       /*if(i==al.size()-1)
				       {
				        out.print(writingJson);
				        break;
				       }
				       out.print(writingJson+",");*/
				 
				 }
				  out.print("</table>");
				  out.print("</body>");
				  out.print("</HTML>");
				 
				 //response.sendRedirect("ShowRequest");
			}
			else
			{
				 response.setContentType("text/html");
				 PrintWriter out = response.getWriter();
				 out.print("<link href='css/bootstrap.min.css' rel='stylesheet' /> <link href='plugins/flexslider/flexslider.css' rel='stylesheet' media='screen' />	<link href='css/cubeportfolio.min.css' rel='stylesheet' /><link href='css/style.css' rel='stylesheet' /><link id='t-colors' href='skins/default.css' rel='stylesheet' /><link id='bodybg' href='bodybg/bg1.css' rel='stylesheet' type='text/css' />");
				  out.print("<img src='img/logo.jpg' alt='' width='100' height='100' /> ");
				  out.print("<hr class='colorgraph'>");
				  out.print("<h2>LogIn Failed.... Wrong Details....</h2>");
				  out.print("<hr class='colorgraph'>");
				 out.print("<a href='index.html'> Go To Home</a>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
