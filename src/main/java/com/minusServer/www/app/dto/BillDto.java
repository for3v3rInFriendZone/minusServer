package com.minusServer.www.app.dto;

import java.math.BigDecimal;
import java.util.List;

public class BillDto extends AbstractDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String location;
	private String issuer;
	private Long date;
	private BigDecimal price;
	private List<Integer> items;
	private Integer userId;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {	
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getIssuer() {
		return issuer;
	}
	
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	
	public Long getDate() {
		return date;
	}
	
	public void setDate(Long date) {
		this.date = date;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Integer> getItems() {
		return items;
	}

	public void setItems(List<Integer> items) {
		this.items = items;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
