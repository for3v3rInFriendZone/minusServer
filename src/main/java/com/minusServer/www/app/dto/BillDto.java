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
	private String date;
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
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
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
	
	/*public BillDto() {
		super();
	}

	public BillDto(Long id, String name, String location, String issuer, String date, BigDecimal price,
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
	}*/
}
