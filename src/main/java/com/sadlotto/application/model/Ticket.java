package com.sadlotto.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket implements Comparable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_id")
	private long id;
	
	@OneToOne
    @JoinColumn(name="purchase_user_id", referencedColumnName="user_id")
	private User purchaseUser;
	
	private Date purchaseDate;
		
	@OneToMany(targetEntity=NumberGroup.class, mappedBy="ticket", fetch=FetchType.LAZY)
	private List<NumberGroup> numberGroups;
	
	@OneToMany(targetEntity=Transaction.class, mappedBy="ticket", fetch=FetchType.LAZY)
	private List<Transaction> transactions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getPurchaseUser() {
		return purchaseUser;
	}

	public void setPurchaseUser(User purchaseUser) {
		this.purchaseUser = purchaseUser;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public List<NumberGroup> getNumberGroups() {
		return numberGroups;
	}

	public void setNumberGroups(List<NumberGroup> numberGroups) {
		this.numberGroups = numberGroups;
	}	

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}  
	

} 