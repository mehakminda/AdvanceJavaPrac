package com.learning.telusko.beans;

public class Employee {
	private Integer id;
	private String empName;
	private String empCity;
	private Float empSalary;

	static {
		System.out.println("Employee class is loaded ...");
		
	}

	public Employee(){
		System.out.println("Employee bean is created ...");

	}

	public Employee(Integer id, String empName, String empCity, Float empSalary) {
		super();
		this.id = id;
		this.empName = empName;
		this.empCity = empCity;
		this.empSalary = empSalary;
		System.out.println("Parameterised constructor invoked");
	}
	
	public String empActivity() {
		System.out.println("Employee usually sleeps at office hour after lunch");
		return "If Manager is present employee will try to act active";
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", EmpName=" + empName + ", empCity=" + empCity + ", empSalary=" + empSalary
				+ "]";
	}
	
}
