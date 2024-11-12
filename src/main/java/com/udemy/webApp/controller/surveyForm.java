package com.udemy.webApp.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class surveyForm {

	@Min(0)
	@Max(150)
	@NotNull
	private int age;
	
	@Min(1)
	@Max(5)
	@NotNull
	private int satisfaction;
	
	@Size(min = 1, max = 200, message = "1文字以上200文字以下で入力をお願い致します。")
	@NotNull
	private String comment;

	public surveyForm() {

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
