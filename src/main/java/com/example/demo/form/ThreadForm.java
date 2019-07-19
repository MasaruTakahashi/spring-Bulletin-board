package com.example.demo.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class ThreadForm implements Serializable{

	@NotEmpty
	private String name;
	private int userId;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
