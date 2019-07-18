package com.example.demo.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserForm implements Serializable{

	@NotEmpty(message = "ログインIDを入力してください")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "英数で入力してください")
	private String loginId;
	@NotEmpty(message = "ログインIDを入力してください")
	@Size(min = 6, message = "{min}文字以上で入力してください")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "英数で入力してください")
	private String password;
	private String passwordCon;
	@NotEmpty(message = "名前を入力してください")
	private String name;

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordCon() {
		return passwordCon;
	}
	public void setPasswordCon(String passwordCon) {
		this.passwordCon = passwordCon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
