package com.yedam.java.app.login;

public class User {

	private String userId;
	private String userPassword;
	private String userName;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "아이디 : " + userId + ", 패스워드 : " + userPassword + ", 회원명 : " + userName;
	}
	
}
