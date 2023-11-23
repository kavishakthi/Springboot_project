package com.kavs.placement;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//Entity Class
@Entity
public class Placement {

	//Fields
	@Id
	private int id;
	private String name, Qualification, collegename;
	
	@Column(nullable = false)
	private int year;
	private  LocalDate Deadline;
	private String Companyname, status;

	// Default constructor 
    public Placement() {
    }
    
 // Parameterized constructor
    public Placement(int id, String name, String qualification, String collegename,String Companyname, String status, LocalDate Deadline, int year)
    {
		this.id = id;
		this.name = name;
		Qualification = qualification;
		this.collegename = collegename;
		this.year = year;
		this.status = status;
		this.Deadline = Deadline;
		this.Companyname = Companyname;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public LocalDate getDeadline() {
		return Deadline;
	}

	public void setDeadline(LocalDate deadline) {
		Deadline = deadline;
	}
	
	public String getCompanyname() {
		return Companyname;
	}

	public void setCompanyname(String companyname) {
		Companyname = companyname;
	}

	@Override
	public String toString() {
		return "Placement [id=" + id + ", name=" + name + ", Qualification=" + Qualification + ", collegename="
				+ collegename + ", year=" + year + ", Deadline=" + Deadline + ", Companyname="
				+ Companyname + ", status=" + status + "]";
	}

	
	
}
