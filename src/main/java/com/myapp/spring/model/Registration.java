package com.myapp.spring.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registration")
public class Registration {

	@Id
	@Column(name = "email_id",nullable = false)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String emailId;
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@Column(name = "full_name",nullable = false)
	private String fullName;
	
	@Column(name = "gender",nullable = false)
	private String gender;
	
	@Column(name = "date_of_birth",nullable = false)
	private String dateOfBirth;

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(String emailId, String password, String fullName, String gender, String dateOfBirth) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfBirth, emailId, fullName, gender, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registration other = (Registration) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(fullName, other.fullName) && Objects.equals(gender, other.gender)
				&& Objects.equals(password, other.password);
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Registration [emailId=");
		builder.append(emailId);
		builder.append(", password=");
		builder.append(password);
		builder.append(", fullName=");
		builder.append(fullName);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append("]");
		return builder.toString();
	}
	
	
}