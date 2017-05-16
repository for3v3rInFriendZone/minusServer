package com.minusServer.www.app.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class AbstractDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	//TODO
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}