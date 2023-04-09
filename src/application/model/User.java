package application.model;

public class User {
	private String username;
	private String password;
	private String role;
	
	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public void setUserName(String userName) {
		this.username = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getUserName() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getRole() {
		return this.role;
	}
}
