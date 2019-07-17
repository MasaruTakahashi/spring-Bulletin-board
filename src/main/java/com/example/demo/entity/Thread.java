package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "thread")
public class Thread {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Date createDate;
	private int userId;

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
	public Date getCreate_date() {
		return createDate;
	}
	public void setCreate_date(Date createDate) {
		this.createDate = createDate;
	}
	public int getUser_id() {
		return userId;
	}
	public void setUser_id(int userId) {
		this.userId = userId;
	}


}
