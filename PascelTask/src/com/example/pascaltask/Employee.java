package com.example.pascaltask;

public class Employee {
	String first,last;
	int age;
	float sal;
	
	public Employee(String first, String last, int age, float sal){
		this.first = first;
		this.last = last;
		this.age = age;
		this.sal = sal;
	}
	
	public Employee(String first, String last){
		this.first = first;
		this.last = last;
	}
	
	public String getFirst(){
		return first;
	}
	public String getLast(){
		return last;
	}
	public int getAge(){
		return age;
	}
	public float getSal(){
		return sal;
	}

}
