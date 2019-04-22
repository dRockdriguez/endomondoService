package endomondo.endomondoAPI.model;
 
import java.io.Serializable;

public class User implements Serializable {
		
	public User(String email, String password, String deviceId) {
		super();
		this.email = email;
		this.password = password;
		this.deviceId = deviceId;
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
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	
	private String email;
	private String password;
	private String deviceId;
}
