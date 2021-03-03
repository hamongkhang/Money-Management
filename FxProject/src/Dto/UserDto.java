package Dto;

import java.sql.Date;

public class UserDto {

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	private int id;
	private String firstname;
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	private String lastname;
	private String username;
	private String password;
	private String birthday;
	private String phoneNumber;
	private String address;
	private double loanamout;
	private int limit;
	public double getLoanamout() {
		return loanamout;
	}

	public void setLoanamout(double loanamout) {
		this.loanamout = loanamout;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public double getEMI() {
		return EMI;
	}

	public void setEMI(double eMI) {
		EMI = eMI;
	}

	private double EMI;

	public UserDto() {

	}

	public UserDto(String fname, String lastname, String username, String password, String phoneNumber, String address
			,String gt,String birthday) {
		this.firstname = fname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.gender=gt;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public UserDto(int id, String username, String password, String birthday, String phoneNumber, String address) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

}
