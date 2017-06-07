package com.minusServer.www.app.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BUDGET")
public class Budget extends AbstractBaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "DATEFROM")
	private Date dateFrom;
	
	@NotNull
	@Column(name = "DATETO")
	private Date dateTo;
	
	@NotNull
	@Column(name = "VALUE")
	private BigDecimal value;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MINUSUSER", nullable = true)
	private User user;

	public Budget(Date dateFrom, Date dateTo, BigDecimal value) {
		super();
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.value = value;
	}

	public Budget() {
		super();
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

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
}
