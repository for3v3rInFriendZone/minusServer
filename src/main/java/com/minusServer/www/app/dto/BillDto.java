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
	private Long date;
	private BigDecimal price;
	private List<ItemDto> items = new ArrayList<ItemDto>();
	private UserDto user;
	
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
	
	public List<ItemDto> getItems() {
		return items;
	}
	
	public void setItems(List<ItemDto> items) {
		this.items = items;
	}
	
	public UserDto getUser() {
		return user;
	}
	
	public void setUser(UserDto user) {
		this.user = user;
	}

	public BillDto() {
		super();
	}

	public BillDto(String name, String location, String issuer, Long date, BigDecimal price,
			List<ItemDto> items, UserDto user) {
		super();
		this.name = name;
		this.location = location;
		this.issuer = issuer;
		this.date = date;
		this.price = price;
		this.items = items;
		this.user = user;
	}
}
