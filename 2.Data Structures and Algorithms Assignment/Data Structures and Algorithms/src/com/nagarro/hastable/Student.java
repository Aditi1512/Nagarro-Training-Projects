package com.nagarro.hastable;

public class Student {

	private String firstName;
	private String lastName;
	private String enrollmentId;

	public Student(String firstName, String lastName, String enrollmentId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.enrollmentId = enrollmentId;
	}

	public String getGnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public Student() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ",  enrollmentId=" + enrollmentId + "]";
	}

}
