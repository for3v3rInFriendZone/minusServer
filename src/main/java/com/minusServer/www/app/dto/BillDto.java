package com.minusServer.www.app.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String location;
	private String issuer;
	private Date date;
	private BigDecimal price;
	private List<ItemDto> items = new ArrayList<ItemDto>();
	private Long user;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public List<ItemDto> getItems() {
		return items;
	}
	
	public void setItems(List<ItemDto> items) {
		this.items = items;
	}
	
	public Long getUser() {
		return user;
	}
	
	public void setUser(Long user) {
		this.user = user;
	}

	public BillDto() {
		super();
	}

	public BillDto(Long id, String name, String location, String issuer, Date date, BigDecimal price,
			List<ItemDto> items, Long user) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.issuer = issuer;
		this.date = date;
		this.price = price;
		this.items = items;
		this.user = user;
	}
}
