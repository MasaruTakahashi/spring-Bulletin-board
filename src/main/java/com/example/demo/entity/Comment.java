package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userId;
	private String detail;
	private Date create_date;
	private int thredId;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser_id() {
		return userId;
	}
	public void setUser_id(String userId) {
		this.userId = userId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public int getThred_id() {
		return thredId;
	}
	public void setThred_id(int thredId) {
		this.thredId = thredId;
	}


}
