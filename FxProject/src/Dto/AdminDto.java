package Dto;
import java.sql.Date;

public class AdminDto {





	private Integer id;
	private String code;
	private String firstName;
	private String lastName;
	private String birthday;
	private String phoneNumber;
	private String gender;
	private Double salary;
	private String address;

	public  AdminDto() {

	}

	public  AdminDto(String code, String firstName, String lastName, String birthday, String phoneNumber,
			String gender, Double salary, String address) {
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.salary = salary;
		this.address = address;
	}

	public  AdminDto(Integer id, String code, String firstName, String lastName, String birthday, String phoneNumber,
			String gender, Double salary, String address) {
		this.id = id;
		this.code = code;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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



