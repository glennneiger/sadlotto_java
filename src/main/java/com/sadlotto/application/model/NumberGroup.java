package com.sadlotto.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "number_groups")
public class NumberGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "number_group_id")
	private long id;

	@ManyToOne
    @JoinColumn(name="ticket_id", nullable=false)
	private Ticket ticket;
	
	@NotNull
	private Integer number1;
	
	@NotNull
	private Integer number2;
	
	@NotNull
	private Integer number3;
	
	@NotNull
	private Integer number4;
	
	@NotNull
	private Integer number5;
	
	@NotNull
	private Integer number6;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Integer getNumber1() {
		return number1;
	}

	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}

	public Integer getNumber2() {
		return number2;
	}

	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}

	public Integer getNumber3() {
		return number3;
	}

	public void setNumber3(Integer number3) {
		this.number3 = number3;
	}

	public Integer getNumber4() {
		return number4;
	}

	public void setNumber4(Integer number4) {
		this.number4 = number4;
	}

	public Integer getNumber5() {
		return number5;
	}

	public void setNumber5(Integer number5) {
		this.number5 = number5;
	}

	public Integer getNumber6() {
		return number6;
	}

	public void setNumber6(Integer number6) {
		this.number6 = number6;
	}	
	
} 