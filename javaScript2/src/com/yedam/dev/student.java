package com.yedam.dev;

public class student {
	String sName;
	String sNumber;
	int age;
	
	public student(String sName, String sNumber, int age) {
		super();
		this.sName = sName;
		this.sNumber = sNumber;
		this.age = age;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	@Override
	public String toString() {
		return "student [sName=" + sName + ", sNumber=" + sNumber + ", age=" + age + "]";
	}

	public String getsNumber() {
		return sNumber;
	}

	public void setsNumber(String sNumber) {
		this.sNumber = sNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
