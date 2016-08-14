package com.eticaretforsalesite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Müsteri")
public class UserBean {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "userId")
	private String userId;
	@Column(name = "userName")
	private String userName;
	@Column(name = "userEmail")
	private String userEmail;
	@Column(name = "userPassword")
	private String userPassword;
	@Column(name = "userAddress")
	private String userAddress;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBean(String userId, String userName, String userEmail, String userPassword, String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
	}
	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userAddress=" + userAddress + "]";
	}
	
	
	
	
}
