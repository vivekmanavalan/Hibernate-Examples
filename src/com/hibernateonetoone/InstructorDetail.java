package com.hibernateonetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column(name="github_account")
	private String github_account;
	
	@Column(name="hobby")
	private String hobby;
	
	
	public InstructorDetail(String github_account, String hobby) {
		super();
		this.github_account = github_account;
		this.hobby = hobby;
	}

	public InstructorDetail () {
		
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", github_account=" + github_account + ", hobby=" + hobby + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGithub_account() {
		return github_account;
	}

	public void setGithub_account(String github_account) {
		this.github_account = github_account;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	

}
