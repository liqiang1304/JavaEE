package edu.tongji.javaee.exam.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Customer implements Serializable {
	private String lastName;
	private String firstName;
	private String password;
	private String middleInitial;
	private String username;	
	private String phone;
	private String fax;	
	private String company;
	private String email;
	private boolean privacy;	
	private boolean shareScore;	
	private String cellPhone;
	private Timestamp creationDate;
	private Timestamp updateDate;
	private String updateID;
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isPrivacy() {
		return privacy;
	}

	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}

	public boolean isShareScore() {
		return shareScore;
	}

	public void setShareScore(boolean shareScore) {
		this.shareScore = shareScore;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateID() {
		return updateID;
	}

	public void setUpdateID(String updateID) {
		this.updateID = updateID;
	}

	
	public Customer() {
		// TODO Auto-generated constructor stub
	       setCellPhone("");
	       setCompany("");
	       setCreationDate(new Timestamp(0));
	       setEmail("");
	       setFax("");
	       setFirstName("");
	       setLastName("");
	       setMiddleInitial("");
	       setPassword("");
	       setPhone("");
	       setPrivacy(false);
	       setShareScore(false);
	       setUpdateDate(new Timestamp(0));
	       setUpdateID("");
	       setUsername("");
	}

}
