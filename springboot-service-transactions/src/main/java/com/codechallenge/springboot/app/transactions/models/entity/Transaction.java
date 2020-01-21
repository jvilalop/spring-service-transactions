package com.codechallenge.springboot.app.transactions.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="transactions") 
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Basic(optional = true)
    @Column(nullable = false)
    private String reference;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private Double ammount;
    
    @Basic(optional = true)
    @Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-ddHH:mm:ss.SSSZ")
    private Date date;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private String account;
    
    @Basic(optional = true)
    @Column(nullable = false)
    private Double fee;
    
    @Basic(optional = true)
    @Column(nullable = false)
    private String description;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    } 

    public String getReference() {
        return reference;
    }
    
    public void setReference(String reference) {
        this.reference = reference;
    }
    
    public Double getAmmount() {
        return ammount;
    }
    
    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }
    
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
    public String getAccount() {
        return account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }
    
    public Double getFee() {
        return fee;
    }
    
    public void setFee(Double fee) {
        this.fee = fee;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
     
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Reference: " + reference + ";");
        buffer.append("Account: " + account + ";");
        buffer.append("Date: " + date + ";");
        buffer.append("Ammount: " + ammount + ";");
        buffer.append("Fee: " + fee + ";");
        buffer.append("Description: " + description);
        return buffer.toString();
    }
}