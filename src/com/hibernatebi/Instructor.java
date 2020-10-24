package com.hibernatebi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="course_instructor")
public class Instructor {

	//Generated type.identity means it is a sequence that is auto incremented in the table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="email")
	private String email;
	
	
	//ManytoOne is the type of mapping between the tables
	//Join column is used to link the two tables based on the primary and foreign keys
	//We will inject values to the instructor detail table using the below variable
	
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name="instructor_id") 
	  private InstructorDetail instructorDetail;
	  
	  //Here we explicitly specify EAGER because by default onetomany is LAZY
	  @OneToMany(fetch = FetchType.LAZY, mappedBy="instructor" ,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	  private List<Course> courses;
	  
	public Instructor () {
		
	}

	public Instructor(String first_name, String email) {
		super();
		this.first_name = first_name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	//Adding the below method for bi-directional mapping between the course and the instructor
	
	public void add (Course tempCourse) {
		if(courses==null) {
			courses = new ArrayList<Course>();
		}
		
		courses.add(tempCourse);
		
		tempCourse.setInstructor(this);
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", first_name=" + first_name + ", email=" + email + ", instructorDetail="
				+ instructorDetail + ", courses=" + courses + "]";
	}
}
