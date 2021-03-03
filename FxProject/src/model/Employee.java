package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Employee {

	private Integer id;

	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String phoneNumber;
	private String gender;
    private Double salary;
	private String address;


	public Employee() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee(String firstName, String lastName, String dateOfBirth, String phoneNumber, String gender,
			Double salary, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.salary = salary;
		this.address = address;
	}

	public Employee(Integer id, String code, String firstName, String lastName, String dateOfBirth, String phoneNumber,
			String gender,  String address) {
		this.id = new Integer(id);

		this.firstName = new String(firstName);
		this.lastName = new String(lastName);
		this.dateOfBirth = new String(dateOfBirth);
		this.phoneNumber = new String(phoneNumber);
		this.gender = new String(gender);
		this.address = new String(address);
	}}

	
