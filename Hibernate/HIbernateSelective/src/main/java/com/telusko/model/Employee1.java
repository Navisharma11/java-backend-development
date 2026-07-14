package com.telusko.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Employee1 
{

	   @Id
		private Integer eId;
		
		private String eName;
		
		@Transient
		private String eCity;
		
		private Integer eAge;
		
		public Employee1()
		{
			System.out.println("Zero Param Constructor for Hibernate");
		}

		public Integer geteId() {
			return eId;
		}

		public void seteId(Integer eId) {
			this.eId = eId;
		}

		public String geteName() {
			return eName;
		}

		public void seteName(String eName) {
			this.eName = eName;
		}

		public String geteCity() {
			return eCity;
		}

		public void seteCity(String eCity) {
			this.eCity = eCity;
		}

		public Integer geteAge() {
			return eAge;
		}

		public void seteAge(Integer eAge) {
			this.eAge = eAge;
		}

		@Override
		public String toString() {
			return "Employee1 [eId=" + eId + ", eName=" + eName + ", eCity=" + eCity + ", eAge=" + eAge + "]";
		}
		
		
		

		
	}


