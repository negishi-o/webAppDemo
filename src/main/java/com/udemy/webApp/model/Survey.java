package com.udemy.webApp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="survey")
public class Survey {

	//自動採番を適応
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer age;
	private Integer satisfaction;
	private String comment;
	
	 
	@Column(name = "created", nullable = false,
			columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created;
	
	public Survey() {
		
	}
	
	public Survey(Integer age, Integer satisfaction, String comment) {
		this.age = age;
		this.satisfaction = satisfaction;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(Integer satisfaction) {
		this.satisfaction = satisfaction;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDateTime getDatetime() {
		return created;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.created = datetime;
	}
}
