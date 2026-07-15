package com.navi.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Table(name="StudentTable")
public class Student 
{
	@Id
	@Column(name="SID")
	private Integer sid;
	
	@Column(name="SNAME")
	private String sName;
	
	@Column(name="SCITY")
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
