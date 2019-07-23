package com.example.demo.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class ThreadForm implements Serializable{

	@NotEmpty(message = "文字が入力されてません")
	private String name;
	private Long id;;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
