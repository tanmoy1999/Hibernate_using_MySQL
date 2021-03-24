package com.hibernate.sample;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String name;
	private String dept;
	private String salary;
	private String position;
	
	public Employee(String name, String dept, String salary, String position) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
