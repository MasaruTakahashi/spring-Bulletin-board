package com.example.demo.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserForm implements Serializable{

	@NotEmpty
	@Pattern(regexp = "[a-zA-Z0-9")
	private String login_id;
	@NotEmpty
	@Size(min = 6)
	@Pattern(regexp = "[a-zA-Z0-9")
	private String password;
	@NotEmpty
	private String name;
}
