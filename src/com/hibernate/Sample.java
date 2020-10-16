package com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

//Table name is sample and table name should be same as class name otherwise it will not be able to map 
// throw a unmapped error

@Table(name="Sample")
public class Sample {
	
	//Default constructor is created to retrieve values from DB
	public Sample() {
		
	}
	

	public Sample(String name, int age, String gender) {
		super();
		
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	//@Id means that the column is a primary key
	
	//@GeneratedValue means we create a sequence so that it automatically iterates that field
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	@Column(name="gender")
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
