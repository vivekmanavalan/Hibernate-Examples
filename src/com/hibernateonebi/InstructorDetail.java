package com.hibernateonebi;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

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
	
	//Below we tell the hibernate that the instructor detail is mapped by instructor class
	//By this way we can make two way binding of tables now we can make it delete from any table 
	@OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Instructor instructor;
	
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

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
