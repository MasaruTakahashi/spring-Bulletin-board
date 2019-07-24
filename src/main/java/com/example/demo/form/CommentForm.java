package com.example.demo.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class CommentForm implements Serializable{

	@NotEmpty(message = "文字を入力してください")
	private String detail;
	private int threadId;
	private Long id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getThreadId() {
		return threadId;
	}
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}


}
