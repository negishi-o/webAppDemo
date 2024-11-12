package com.udemy.webApp.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class InqueryForm {

	@Size(min = 1, max = 20, message = "文字数が長いよ！！")
	private String name;
	
	@NotBlank
	@Email(message="正しいメールアドレス入力してね")
	private String email;
	
	@NotBlank
	private String contents;
	
	public InqueryForm() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
}
