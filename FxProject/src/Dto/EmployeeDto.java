package Dto;

import java.sql.Date;

public class EmployeeDto {

	private Integer id;

	private String firstName;
	private String lastName;
	private String birthday;
	private String phoneNumber;
	private String gender;
	private Double salary;
	private String address;
	private String la;

	public String getLa() {
		return la;
	}

	public void setLa(String la) {
		this.la = la;
	}

	public EmployeeDto() {

	}

	public EmployeeDto(String code, String firstName, String lastName, String birthday, String phoneNumber,
			String gender, Double salary, String address) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.salary = salary;
		this.address = address;
	}

	public EmployeeDto(Integer id, String code, String firstName, String lastName, String birthday, String phoneNumber,
			String gender, Double salary, String address) {
		this.id = id;
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.salary = salary;
		this.address = address;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthDay(String birthday) {
		this.birthday = birthday;
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

}
