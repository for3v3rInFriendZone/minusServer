package com.minusServer.www.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BUDGET")
public class Budget implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "DATEFROM")
	private Date dateFrom;
	
	@NotNull
	@Column(name = "DATETO")
	private Date dateTo;
	
	@NotNull
	@Column(name = "STARTVALUE")
	private BigDecimal startValue;

	@NotNull
	@Column(name = "CURRENTVALUE")
	private BigDecimal currentValue;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MINUSUSER", nullable = true)
	private User user;

	public Budget(Date dateFrom, Date dateTo, BigDecimal startValue, BigDecimal currentValue) {
		super();
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.startValue = startValue;
		this.currentValue = currentValue;
	}

	public Budget() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public BigDecimal getStartValue() {
		return startValue;
	}

	public void setStartValue(BigDecimal startValue) {
		this.startValue = startValue;
	}

	public BigDecimal getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(BigDecimal currentValue) {
		this.currentValue = currentValue;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
}
