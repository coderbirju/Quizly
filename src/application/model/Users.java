package application.model;

//import java.util.List;
import java.util.*;

public class Users {
	private List<User> users;
	
	public Users() {
		users = new ArrayList<User>();
		for(int i=0;i<5;i++) {
			users.add(new User("student"+i, "pass"+i, "student"));
		}
		for(int i=0;i<5;i++) {
			users.add(new User("prof"+i, "pass"+i, "prof"));
		}
	}
	
	public List<User> getList(){
		return users;
	}
	
	public User getUser(String username, String password, String role) {
		for(int i=0; i< users.size();i++) {
			User cur = users.get(i);
			if(cur.getUserName() == username && cur.getPassword() == password && cur.getRole() == role) {
				return cur;
			}
		}
		return null;
	}
	
	
}
