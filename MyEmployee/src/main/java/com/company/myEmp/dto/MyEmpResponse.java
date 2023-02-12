package com.company.myEmp.dto;

import org.springframework.stereotype.Component;

@Component
public class MyEmpResponse {

	
	private int eId; 
	private String eName;
	private String ePass;
	private int age;
	
	
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getePass() {
		return ePass;
	}
	public void setePass(String ePass) {
		this.ePass = ePass;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "MyEmpRequest [eId=" + eId + ", eName=" + eName + ", ePass=" + ePass + ", age=" + age + "]";
	}
	
	
	
}
