package com.jc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jc.dao.ContactDao;
import com.jc.pojo.Contact;
import com.jc.pojo.Request;

/**
 * Servlet implementation class ContactServlet
 */
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		ContactDao cd=new ContactDao();
		Request c=new Request();
		c.setName(request.getParameter("name"));
		//System.out.println(request.getParameter("phoneNo"));
		if(request.getParameter("phoneNo")!="" && request.getParameter("emailId")!="" && request.getParameter("msg")!="" && request.getParameter("name")!="" && request.getParameter("phoneNo").length() <=11)
		{
		long phoneNo1=Long.parseLong(request.getParameter("phoneNo"));
				//request.getParameter("phoneNo");
		//int phoneNo1=0;
		c.setPhoneNo(phoneNo1);
		c.setEmailId(request.getParameter("emailId"));
		c.setMsg(request.getParameter("msg"));
		try {
			
			String s=cd.addRequest(c);
			if(s!=null)
			{
				System.out.println("Done");
				response.setContentType("text/html");
				  out.print("<link href='css/bootstrap.min.css' rel='stylesheet' /> <link href='plugins/flexslider/flexslider.css' rel='stylesheet' media='screen' />	<link href='css/cubeportfolio.min.css' rel='stylesheet' /><link href='css/style.css' rel='stylesheet' /><link id='t-colors' href='skins/default.css' rel='stylesheet' /><link id='bodybg' href='bodybg/bg1.css' rel='stylesheet' type='text/css' />");

				//out.println("<script>window.alert('Submitted :)')</script>");
				out.print("<div class='cta-text'> <h2>Submitted And Service Request No is-<span>"+s+"</span> Note it down for future uses.<span>We will contact with You very shortly</span>,Have A Good Day :)</h2></div><hr class='colorgraph'>");
				out.println("<br><a class='btn btn-theme btn-lg' href='http://www.jctechnology.in/index.html'>Go To Home</a>");
				//response.sendRedirect("index.html");
			}
			else
			{
				response.setContentType("text/html");
				out.print("Failed :(");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			response.setContentType("text/html");
			out.print("Failed :(............ Please provide numeric value in Phone No field <br> <br><a href='http://www.jctechnology.in/index.html'>Go Back To Home </a>");
			e.printStackTrace();
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		out.close();
		}
		else
		{
			response.setContentType("text/html");
			  out.print("<link href='css/bootstrap.min.css' rel='stylesheet' /> <link href='plugins/flexslider/flexslider.css' rel='stylesheet' media='screen' />	<link href='css/cubeportfolio.min.css' rel='stylesheet' /><link href='css/style.css' rel='stylesheet' /><link id='t-colors' href='skins/default.css' rel='stylesheet' /><link id='bodybg' href='bodybg/bg1.css' rel='stylesheet' type='text/css' />");
			  //out.print("<hr class='colorgraph'>");
			out.print("<a href='http://jctechnology.in/index.html/index.html'><img src='img/logo.jpg' alt='' width='100' height='100' /> </a><h3><strong>Failed!</strong> You have done some mistakes..</h3> <li>Please provide numeric value in Phone No field <li> No Null Values are allowed in Name,Email Id,Message Fields... <li>If Everything fine then check that the phone no length is 10 or not..<hr class='colorgraph'><br>Sample Data- <br> Name - Souvik Das <br> Phone No- 1111222233 <br>Email Id- abc@xyz.com<br> Message-Abcccdd <hr class='colorgraph'> <a href='http://www.jctechnology.in/index.html'>Go Back To Home </a> <br>");
		}
			
	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		ContactDao cd=new ContactDao();
		Contact c=new Contact();
		
		c.setName(request.getParameter("name"));
		c.setEmailId(request.getParameter("emailId"));
		c.setMsg(request.getParameter("msg"));
		try {
			if(cd.addContact(c) && c.getEmailId()!="" && c.getMsg()!="" && c.getName()!="")
			{
				response.setContentType("text/html");
				  out.print("<link href='css/bootstrap.min.css' rel='stylesheet' /> <link href='plugins/flexslider/flexslider.css' rel='stylesheet' media='screen' />	<link href='css/cubeportfolio.min.css' rel='stylesheet' /><link href='css/style.css' rel='stylesheet' /><link id='t-colors' href='skins/default.css' rel='stylesheet' /><link id='bodybg' href='bodybg/bg1.css' rel='stylesheet' type='text/css' />");

				//out.println("<script>window.alert('Submitted :)')</script>");
				out.print("<div class='cta-text'> <h2>Submitted .<span>We will contact with You very shortly</span>,Have A Good Day :)</h2></div><hr class='colorgraph'>");
				out.println("<br><a class='btn btn-theme btn-lg' href='http://www.jctechnology.in/index.html'>Go To Home</a>");
			}
			else
			{
				response.setContentType("text/html");
				  out.print("<link href='css/bootstrap.min.css' rel='stylesheet' /> <link href='plugins/flexslider/flexslider.css' rel='stylesheet' media='screen' />	<link href='css/cubeportfolio.min.css' rel='stylesheet' /><link href='css/style.css' rel='stylesheet' /><link id='t-colors' href='skins/default.css' rel='stylesheet' /><link id='bodybg' href='bodybg/bg1.css' rel='stylesheet' type='text/css' />");

					out.print("<img src='img/logo.jpg' alt='' width='100' height='100' /> <h3><strong>Failed!</strong> You have done some mistakes..</h3> <li> No Null Values are allowed in Name,Email Id,Message Fields.. <hr class='colorgraph'><br><hr class='colorgraph'> <a href='http://www.jctechnology.in/index.html'>Go Back To Home </a> <br>");

			}
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
