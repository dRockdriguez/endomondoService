package endomondo.utils;

import java.util.HashMap;

public class Common {

	public Common() {
		this.paths =  new HashMap<String, Object>();
		this.paths.put("auth", "mobile/auth");
		this.paths.put("activitiesList", "mobile/api/workout/list");
		HashMap<String, String> activity = new HashMap<String, String>();
		activity.put("get", "mobile/api/workout/get");
		activity.put("post", "mobile/track");
		this.paths.put("activity", activity);
		
		HashMap<String, String> workout = new HashMap<String, String>();
		workout.put("isOk", "/OK\n/");
		this.regex = new HashMap<String, Object>();
		this.regex.put("workout", workout);
		
		HashMap<String, String> auth = new HashMap<String, String>();
		auth.put("isOk", "/OK\n/");
		auth.put("authToken", "/authToken=(.*?)\n/");
		auth.put("measure", "/measure=(.*?)\n/");
		auth.put("displayName", "/displayName=(.*?)\n/");
		auth.put("userId", "/userId=(.*?)\n/");
		auth.put("facebookConnected", "/facebookConnected=(.*?)\n/");
		auth.put("secureToken", "/secureToken=(.*?)\n/");	
	}

	public HashMap<String, Object> getPaths() {
		return paths;
	}

	public void setPaths(HashMap<String, Object> paths) {
		this.paths = paths;
	}

	public HashMap<String, Object> getRegex() {
		return regex;
	}

	public void setRegex(HashMap<String, Object> regex) {
		this.regex = regex;
	}
	
	public static final String api = "https://api.mobile.endomondo.com/";
	public HashMap<String, Object> paths;
	public HashMap<String, Object> regex;
}
