package com.jc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.jc.dao.DataSource;
import com.jc.pojo.Contact;
import com.jc.pojo.Request;

public class ContactDao {
	Connection con = null;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String cd=dateFormat.format(new java.util.Date());
	
	public Boolean addContact(Contact c) throws SQLException, IOException, ParseException
	{
		
		String name=c.getName();
		String email=c.getEmailId();
		String msg=c.getMsg();
		
		con = DataSource.getInstance().getConnection();
		Statement st=(Statement) con.createStatement();
		int result= st.executeUpdate("INSERT INTO contactUs(name,email,msg) VALUES('"+name+"','"+email+"','"+msg+"')");
		if(result>0)
		{
			con.close();
			return true;
		}
		return false;
	}
	
	
	public String addRequest(Request c) throws SQLException, IOException, ParseException
	{
		java.util.Date date = dateFormat.parse(cd);
		String name=c.getName();
		long phoneNo=c.getPhoneNo();
		String email=c.getEmailId();
		String msg=c.getMsg();
		Date d=new Date(date.getTime());
		con = DataSource.getInstance().getConnection();
		Statement st=(Statement) con.createStatement();
		int result= st.executeUpdate("INSERT INTO request(name,phoneNo,emailId,msg,create_date) VALUES('"+name+"','"+phoneNo+"','"+email+"','"+msg+"','"+d+"')");
		if(result>0)
		{
			//Statement st1 = con.createStatement(); 
			String sNo=null;
			ResultSet rs= st.executeQuery("Select * from request where name='"+name+"' and msg='"+msg+"'");
			while(rs.next())
			{
			Integer rNo=rs.getInt(1);
			sNo=rNo.toString();
			
			}
			con.close();
			return sNo;
		}
		return null;
	}
	public ArrayList<Request> getAllRequest() {

		ArrayList<Request> actorl=new ArrayList<Request>();

		try{
			con = DataSource.getInstance().getConnection();
			Statement st = con.createStatement(); 
			ResultSet rs= st.executeQuery("Select * from request");
			while(rs.next()){  

				Request a=new Request();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPhoneNo(rs.getLong(3));
				a.setEmailId(rs.getString(4));
				a.setMsg(rs.getString(5));
				a.setCreateDate(rs.getDate(6));
				
				actorl.add(a);

			}

			con.close();
			return actorl;
		} catch(Exception e) {
			System.out.println("Exception Occured");
		}  
		return actorl;

	}
	public boolean adminLogIn(String uname,String password) throws SQLException, IOException
	{
		String un="";
		String pwd="";
		con = DataSource.getInstance().getConnection();
		Statement st=(Statement) con.createStatement();
		ResultSet rs= st.executeQuery("Select * from admin");
		while(rs.next()){  
			un=rs.getString(1);
			pwd=rs.getString(2);
			System.out.println(un);
			System.out.println(pwd);
		}
		if(uname.equals(un) && password.equals(pwd))
		{
			return true;
		}
		return false;

	}
	public boolean deleteRequest(int i) throws SQLException, IOException
	{
		con = DataSource.getInstance().getConnection();
		Statement st = con.createStatement(); 
		int result= st.executeUpdate("delete from request where id='"+i+"'");
		if(result>0)
			return true;
		return false;
	}
	
	public ArrayList<Contact> getAllContact() {

		ArrayList<Contact> contactList=new ArrayList<Contact>();

		try{
			con = DataSource.getInstance().getConnection();
			Statement st = con.createStatement(); 
			ResultSet rs= st.executeQuery("Select * from contactUs");
			while(rs.next()){  

				Contact a=new Contact();
				a.setName(rs.getString(1));
				a.setEmailId(rs.getString(2));
				a.setMsg(rs.getString(3));
				contactList.add(a);

			}

			con.close();
			return contactList;
		} catch(Exception e) {
			System.out.println("Exception Occured");
		}  
		return contactList;

	}
	
	
}
