package com.jc.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import com.jc.pojo.Contact;
import com.jc.pojo.Request;

public class Test {

	public static void main(String[] args) throws SQLException, IOException, ParseException {
		Contact c =new Contact();
		c.setName("Souvik");
		c.setEmailId("sdas.rng@gmail.com");
		c.setMsg("Hello Hi");
		ContactDao cd=new ContactDao();
		cd.addContact(c);
		Request r=new Request();
		r.setName("Souvik Das");
		r.setMsg("Not Working");
		r.setEmailId("Souvik.das@live.in");
		r.setPhoneNo(8436);
		cd.addRequest(r);
		
		System.out.println(cd.adminLogIn("Souvik", "Piyal"));
		
		

	}

}
