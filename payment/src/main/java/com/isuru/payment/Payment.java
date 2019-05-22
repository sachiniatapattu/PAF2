package com.isuru.payment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payment {
	
	private int Id;
	private String date;
	private String details;
	private int total;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Payment [Id=" + Id + ", date=" + date + ", details=" + details + ", total=" + total + "]";
	}
	
	
	
	


}
