package com.hibernateonetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {

	//Generated type.identity means it is a sequence that is auto incremented in the table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	
	//OnetoOne is the type of mapping between the tables
	//Join column is used to link the two tables based on the primary and foreign keys
	//We will inject values to the instructor detail table using the below variable
	
	  @OneToOne(cascade = CascadeType.ALL)
	  
	  @JoinColumn(name="instructor_id") 
	  private InstructorDetail instructorDetail;

	
	public Instructor () {
		
	}

	public Instructor(String first_name, String last_name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.instructorDetail = instructorDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
}
