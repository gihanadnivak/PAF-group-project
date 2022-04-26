package com.telusko.demorests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class TimetableRepository 
{
	
	
	Connection con = null;
	
	public  TimetableRepository()
	{   
		String url="jdbc:mysql://localhost:3306/restdb ";
		String username="root";
		String password="";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection(url,username,password);	
		}
		 catch(Exception e) {
			 System.out.println(e);
		}
	}
	
	
	 public List<Timetable> getTimetables()
	 { 
		 List<Timetable> timetable =new  ArrayList<>();
		 String sql = "select*from timetable";
		 try
		 {
			 Statement st =con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 while(rs.next())
			 {
				 Timetable a = new Timetable();
				 a.setAreacode(rs.getString(1));
				 a.setCatagary(rs.getString(2));
				 a.setDate(rs.getString(3));
				 a.setTime(rs.getString(4));
				 a.setTwon(rs.getString(5));
				 
				 timetable.add(a);
			 }
		 }
		 catch(Exception e) {
			 System.out.println(e);
		}
		 return timetable;
	 }
	 
	 public Timetable getTimetable(String areacode )
	 {
		 String sql = "select*from timetable where areacode="+areacode;
		 Timetable a = new Timetable();
		 try
		 {
			 Statement st =con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 if(rs.next())
			 {
				 
				 a.setAreacode(rs.getString(1));
				 a.setCatagary(rs.getString(2));
				 a.setDate(rs.getString(3));
				 a.setTime(rs.getString(4));
				 a.setTwon(rs.getString(5));
				 
				 
			 }
		 }
		 catch(Exception e) {
			 System.out.println(e);
		}
		 return a;
	 }

	public void create(Timetable t1) {
		// TODO Auto-generated method stub
		
		String sql = "insert into timetable values(?,?,?,?,?)";
		try
		 {
			 PreparedStatement st =con.prepareStatement(sql);
			 st.setString(1, t1.getAreacode());
			 st.setString(2, t1.getCatagary());
			 st.setString(3, t1.getDate());
			 st.setString(4, t1.getTime());
			 st.setString(5, t1.getTwon());
			 st.executeUpdate();
			
			 
		 }
		 catch(Exception e) {
			 System.out.println(e);
		
		
	}
	}
	
	
	public void update(Timetable t1) {
		// TODO Auto-generated method stub
		
		String sql = "update timetable set catagary=?, date=?, time=?, twon=? where areacode=?";
		try
		 {
			 PreparedStatement st =con.prepareStatement(sql);
			
			 st.setString(1, t1.getCatagary());
			 st.setString(2, t1.getDate());
			 st.setString(3, t1.getTime());
			 st.setString(4, t1.getTwon());
			 st.setString(5, t1.getAreacode());
			 st.executeUpdate();
			
			 
		 }
		 catch(Exception e) {
			 System.out.println(e);
		
		
	}
	}


	public void delete(String areacode) {
		// TODO Auto-generated method stub
		
		String sql = "delete from  timetable  where areacode=?";
		try
		 {
			 PreparedStatement st =con.prepareStatement(sql);
			
			 
			 st.setString(1, areacode);
			 st.executeUpdate();
			
			 
		 }
		 catch(Exception e) {
			 System.out.println(e);
		
		
	}
		
	}

}
