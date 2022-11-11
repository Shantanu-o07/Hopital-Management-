package com.example.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hospital")


public class Patient {
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getPatientId() {
		return PatientId;
	}


	public void setPatientId(int patientId) {
		PatientId = patientId;
	}


	public String getPatientName() {
		return PatientName;
	}


	public void setPatientName(String patientName) {
		PatientName = patientName;
	}


	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		Age = age;
	}


	public String getDrName() {
		return DrName;
	}


	public void setDrName(String drName) {
		DrName = drName;
	}


	public String getInsuranceCompany() {
		return InsuranceCompany;
	}


	public void setInsuranceCompany(String insuranceCompany) {
		InsuranceCompany = insuranceCompany;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="PatientId")
	private int PatientId;
	
	public Patient(int patientId, String patientName, int age, String drName, String insuranceCompany) {
		super();
		PatientId = patientId;
		PatientName = patientName;
		Age = age;
		DrName = drName;
		InsuranceCompany = insuranceCompany;
	}


	@Column(name="PatientName")
	private String PatientName;
	
	@Column(name="Age")
	private int Age;
	
	@Column(name="DrName")
	private String DrName;
	
	@Column(name="InsuranceCompany")
	private String InsuranceCompany;
	

	public Patient() {}
	
	
	
	
}

