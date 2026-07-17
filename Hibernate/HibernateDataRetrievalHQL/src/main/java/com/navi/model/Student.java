package com.navi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentTable")
public class Student 
{
	@Id
	private Integer sid;

	private String sName;
	
	private String sCity;

	
	public Student()
	{
		System.out.println("Zero Param Constructor for Hibernate");
	}
	
	
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsCity() {
		return sCity;
	}

	public void setsCity(String sCity) {
		this.sCity = sCity;
	}


	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + ", sCity=" + sCity + "]";
	}


	
	
	

}
