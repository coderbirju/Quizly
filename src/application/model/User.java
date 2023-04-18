package application.model;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import application.ConnectToDB;


public class User {
	
	private static User instance;
	
	private String username;
	private String password;
	private String role;
	
	private User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	protected User() {}
	
	public static User getInstance(String username, String password, String role) {
        if (instance == null) {
        	ConnectToDB db = ConnectToDB.getInstance();
    		
    		MongoCollection<Document> collection = db.getCollection("users");
    		
    		//System.out.println("cString username, String password, String role " + username + password + role);
    		Document query = new Document("username", username).append("password", password).append("role", role);
    		Document user = collection.find(query).first();
    		if(user != null) {    			
    			instance = new User(username, password, role);
    		} else {
    			return null;
    		}
        }
        return instance;
    }
	
	public static void signOut() {
		if(instance != null) {
			instance = null;
			System.out.println("Logged out successfully");
		} else {
			System.out.println("Logged out Already");
		}
	}
	
	public static User getLoggedInUser() {
		if(instance != null)
			return instance;
		return null;
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
