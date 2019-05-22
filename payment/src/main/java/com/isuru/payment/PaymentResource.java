package com.isuru.payment;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("payments")
public class PaymentResource {
	
	PaymentRepository repo = new PaymentRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Payment> getpayments() {
		
		System.out.print("payments details");
		return repo.getpayments();
	}
	
	@GET
	@Path("payment/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Payment getShipping(@PathParam("payment")int id) {
		return repo.getpayment(id);
	}
	
	
	@POST
	@Path("payment")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Payment createShipping(Payment s1) {
		System.out.print(s1);
		repo.create(s1);
		return s1;
	}
	
	@PUT
	@Path("payment")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Payment updateShipping(Payment s1) {
		System.out.print(s1);
		if(repo.getpayment(s1.getId()).getId()==0)
		{
			repo.create(s1);
		}
		else {
			repo.update(s1);
		}
		repo.update(s1);
		return s1;
	}
	
	@DELETE
	@Path("payment/{id}")
	public Payment deleteShipping(@PathParam("payment") int id) {
		Payment s = repo.getpayment(id);
		
		if(s.getId()!=0) 
			repo.delete(id);
		
		return s;
	}
}
