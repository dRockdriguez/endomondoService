package endomondo.utils;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Workouts {
	public String  getWorkouts(String authToken) throws ClientProtocolException, IOException {
		Common com = new Common();
				
		HashMap<String, Object> paths = com.getPaths();
		String url = Common.api + paths.get("activitiesList");
		
		HttpClient client = HttpClientBuilder.create().build();
		String urlParams = url + "?authToken=" + authToken;
		HttpGet request = new HttpGet(urlParams);

		HttpResponse response = client.execute(request);
		
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		
		return responseString;
	}
}
