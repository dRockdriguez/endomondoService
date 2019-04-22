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

public class Workout {
	
	public String  getWorkout(String authToken, String workoutId) throws ClientProtocolException, IOException {
		Common com = new Common();
		String fields = "device,simple,basic,motivation,interval,hr_zones,weather,polyline_encoded_small,points,lcp_count,tagged_users,pictures,feed";
				
		HashMap<String, String> activity = (HashMap<String, String>) com.getPaths().get("activity");
		String url = Common.api + activity.get("get");
		
		HttpClient client = HttpClientBuilder.create().build();
		String urlParams = url + "?authToken=" + authToken + "&workoutId=" + workoutId + "&fields=" + fields;
		HttpGet request = new HttpGet(urlParams);

		HttpResponse response = client.execute(request);
		
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		
		return responseString;
	}
	
}
