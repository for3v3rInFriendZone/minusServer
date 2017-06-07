package com.minusServer.www.app.dto;

import java.math.BigDecimal;

public class BudgetDto extends AbstractDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long dateFrom;
	private Long dateTo;
	private BigDecimal value;
	private UserDto user;
	
	public BudgetDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BudgetDto(Long dateFrom, Long dateTo, BigDecimal value, UserDto user) {
		super();
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.value = value;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDateFrom() {
		return dateFrom;
	}
	
	public void setDateFrom(Long dateFrom) {
		this.dateFrom = dateFrom;
	}
	
	public Long getDateTo() {
		return dateTo;
	}
	
	public void setDateTo(Long dateTo) {
		this.dateTo = dateTo;
	}
	
	public BigDecimal getValue() {
		return value;
	}
	
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	public UserDto getUser() {
		return user;
	}
	
	public void setUser(UserDto user) {
		this.user = user;
	}
}
