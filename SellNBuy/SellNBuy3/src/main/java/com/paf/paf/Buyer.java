package com.paf.paf;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "buyers")
public class Buyer {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "buyer_code", nullable = false, unique = true)
    private String buyerCode;

    @Column(name = "buyer_name", nullable = false)
    private String buyerName;
    
    @Column(name = "buyer_address", nullable = false)
    private String buyerAddress;
    
    @Column(name = "buyer_number", nullable = false)
    private String buyerNumber;
    
    @Column(name = "buyer_date", nullable = false)
    private String buyerDate;

    @Column(name = "buyer_email", nullable = false)
    private String buyerEmail;

    @Column(name = "buyer_password",nullable = false, unique = true)
    private String buyerPassword;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    public Buyer(int id, String buyerCode, String buyerName, String buyerAddress,String buyerNumber,String buyerDate, String buyerEmail, String buyerPassword, Date createdAt, Date updatedAt) {
        this.id = id;
        this.buyerCode = buyerCode;
        this.buyerName = buyerName;
        this.buyerAddress = buyerAddress;
        this.buyerNumber = buyerNumber;
        this.buyerDate = buyerDate;
        this.buyerEmail = buyerEmail;
        this.buyerPassword = buyerPassword;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Buyer(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }
    public void setBuyer_code(String buyer_code) {
        this.buyerCode = buyer_code;
    }
    
    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
   
    public String getBuyerAddress() {
         return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
         this.buyerAddress = buyerAddress;
    }
    
    public String getBuyerNumber() {
        return buyerEmail;
    }

    public void setBuyerNumber(String buyerNumber) {
        this.buyerNumber = buyerNumber;
    }
    
    public String getBuyerDate() {
        return buyerDate;
    }

    public void setBuyerDate(String buyerDate) {
        this.buyerDate = buyerDate;
    }
    
    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getBuyerPassword() {
        return buyerPassword;
    }

    public void setBuyerPassword(String buyerPassword) {
        this.buyerPassword = buyerPassword;
    }
    public void setBuyer_password(String buyerPassword) {
        this.buyerPassword = buyerPassword;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


}
