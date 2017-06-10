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
	private BigDecimal startValue;
	private BigDecimal currentValue;
	private UserDto user;
	
	public BudgetDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BudgetDto(Long dateFrom, Long dateTo, BigDecimal startValue, BigDecimal currentValue, UserDto user) {
		super();
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.startValue = startValue;
		this.currentValue = currentValue;
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
	
	public UserDto getUser() {
		return user;
	}
	
	public void setUser(UserDto user) {
		this.user = user;
	}
}
