package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {

	private SimpleIntegerProperty id;
	private SimpleStringProperty code;
	

	private String Username;
	private String la;
	
	private SimpleStringProperty firstName;
	private SimpleStringProperty lastName;
	private SimpleStringProperty dateOfBirth;
	private SimpleStringProperty phoneNumber;
	private SimpleStringProperty gender;
	private String password;

	private SimpleStringProperty address;


	public User() {
		this.id = new SimpleIntegerProperty();
		this.code = new SimpleStringProperty();
		this.firstName = new SimpleStringProperty();
		this.lastName = new SimpleStringProperty();
		this.dateOfBirth = new SimpleStringProperty();
		this.phoneNumber = new SimpleStringProperty();
		this.gender = new SimpleStringProperty();
		
		this.address = new SimpleStringProperty();
	}

	public User(Integer id, String code, String firstName, String lastName, String dateOfBirth, String phoneNumber,
			String gender,  String address) {
		this.id = new SimpleIntegerProperty(id);
		this.code = new SimpleStringProperty(code);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.dateOfBirth = new SimpleStringProperty(dateOfBirth);
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
		this.gender = new SimpleStringProperty(gender);
		this.address = new SimpleStringProperty(address);
	}
	public User( String code, String firstName, String lastName, String dateOfBirth, String phoneNumber,String gender,  String address) {
		
		this.code = new SimpleStringProperty(code);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.dateOfBirth = new SimpleStringProperty(dateOfBirth);
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
		this.gender = new SimpleStringProperty(gender);
		this.address = new SimpleStringProperty(address);
	}

	public Integer getId() {
		return this.id.get();
	}

	public void setId(Integer id) {
		this.id.set(id);
	}

	public String getCode() {
		return code.get();
	}

	public void setCode(String code) {
		this.code.set(code);
	}

	public String getFirstName() {
		return firstName.get();
	}
	
	public void setFirstName(String firstName) {
		this.firstName.setValue(firstName);
	}
	
	public String getLastName() {
		return this.lastName.get();
	}
	
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}
	
	public String getDateOfBirth() {
		return this.dateOfBirth.get();
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth.set(dateOfBirth);
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber.get();
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.set(phoneNumber);
	}
	
	public String getGender() {
		return this.gender.get();
	}
	
	public void setGender(String gender) {
		this.gender.set(gender);
	}
	
	
	public String getAddress() {
		return this.address.get();
	}

	public void setAddress(String address) {
		this.address.set(address);
	}

	public void setPassword(String string) {
this.password=string;
		
	}
	public String getLa() {
		return la;
	}

	public void setLa(String string) {
		this.la = string;
	}
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public void setId(int a ) {
		this.id.set(a); ;
	}

	public void setCode(SimpleStringProperty code) {
		this.code = code;
	}

	public void setFirstName(SimpleStringProperty firstName) {
		this.firstName = firstName;
	}

	public void setLastName(SimpleStringProperty lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirth(SimpleStringProperty dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setPhoneNumber(SimpleStringProperty phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setGender(SimpleStringProperty gender) {
		this.gender = gender;
	}

	public void setAddress(SimpleStringProperty address) {
		this.address = address;
	}

	public String getBirthday() {
		// TODO Auto-generated method stub
		return null;
	}

}
