package com.jc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jc.dao.ContactDao;

/**
 * Servlet implementation class DelteRequest
 */
public class DelteRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelteRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ContactDao cd=new ContactDao();
		int rNo=Integer.parseInt(request.getParameter("no"));
		try {
			if(cd.deleteRequest(rNo))
			{
				response.setContentType("text/html");
				  out.print("<link href='css/bootstrap.min.css' rel='stylesheet' /> <link href='plugins/flexslider/flexslider.css' rel='stylesheet' media='screen' />	<link href='css/cubeportfolio.min.css' rel='stylesheet' /><link href='css/style.css' rel='stylesheet' /><link id='t-colors' href='skins/default.css' rel='stylesheet' /><link id='bodybg' href='bodybg/bg1.css' rel='stylesheet' type='text/css' />");

				//out.println("<script>window.alert('Submitted :)')</script>");
				out.print("<div class='cta-text'> <h2>Deleted</h2></div><hr class='colorgraph'>");
				out.println("<br><a class='btn btn-theme btn-lg' href='http://jctechnology.in/index.html/index.html'>Go To Home</a>");
			}
			else
			{
				response.setContentType("text/html");
				  out.print("<link href='css/bootstrap.min.css' rel='stylesheet' /> <link href='plugins/flexslider/flexslider.css' rel='stylesheet' media='screen' />	<link href='css/cubeportfolio.min.css' rel='stylesheet' /><link href='css/style.css' rel='stylesheet' /><link id='t-colors' href='skins/default.css' rel='stylesheet' /><link id='bodybg' href='bodybg/bg1.css' rel='stylesheet' type='text/css' />");
				  out.print("<img src='img/logo.jpg' alt='' width='100' height='100' /> ");

				out.print("<h1>Failed :(.. Wrong details provided by you!!!!! </h1>");
					 //out.print("<h2>LogIn Failed.... Wrong Details....</h2>");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
