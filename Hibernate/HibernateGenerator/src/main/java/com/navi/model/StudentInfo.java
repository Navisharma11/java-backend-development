package com.navi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;




@Entity
@Table(name="StudentInfo")
public class StudentInfo
{
	@Id
	@GeneratedValue(generator="my_seq",strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name="my_seq",sequenceName="My_OwnSequence",initialValue=100,allocationSize=1)
	private Integer sid;
	
	private String sName;
	
	private String sCity;

	
	public StudentInfo()
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


