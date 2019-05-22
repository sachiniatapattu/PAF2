package com.isuru.payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PaymentRepository {
	
	
	Connection con = null;
	
	public PaymentRepository() 
	{
		String url = "jdbc:mysql://localhost:3306/pay";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			System.out.print(e);
		}
		
		
	}
	
	public List<Payment> getpayments(){
		
		List<Payment> payment = new ArrayList<>();
		String sql = "select * from sellnbuy";
		
		try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			Payment s = new Payment();
			s.setId(rs.getInt(1));
			s.setDate(rs.getString(2));
			s.setDetails(rs.getString(3));
			s.setTotal(rs.getInt(4));
			
			payment.add(s);
		}
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return payment;
	}
	
	public Payment getpayment(int id) {
		
		String sql = "select * from details where id="+id;
		Payment s = new Payment();
		
		try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) {
			
			s.setId(rs.getInt(1));
			s.setDate(rs.getString(2));
			s.setDetails(rs.getString(3));
			s.setTotal(rs.getInt(4));
					
		}
		
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return s;
	}

	public void create(Payment s1) {
		String sql = "insert into details values(?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, s1.getId());
			st.setString(2, s1.getDate());
			st.setString(3, s1.getDetails());
			st.setInt(4, s1.getTotal());	
			st.executeUpdate();
			
			}
			catch(Exception e) {
				System.out.print(e);
			}
		}
	
	public void update(Payment s1) {
		String sql = "update details set Id=?, date=?, details=? where total=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(4, s1.getId());
			st.setString(1, s1.getDate());
			st.setString(2, s1.getDetails());
			st.setInt(3, s1.getTotal());	
			st.executeUpdate();
			
			}
			catch(Exception e) {
				System.out.print(e);
			}
		}

	public void delete(int id) {
		
		String sql = "delete from details where id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			
			}
			catch(Exception e) {
				System.out.print(e);
			}
		}
	
}
