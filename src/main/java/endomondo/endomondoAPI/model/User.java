package endomondo.endomondoAPI.model;
 
import java.io.Serializable;

public class User implements Serializable {
		
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private String email;
	private String password;
}
