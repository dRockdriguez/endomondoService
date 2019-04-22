package endomondo.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Authentication {
	
	public String authenticate(String email, String password) throws ClientProtocolException, IOException {
		Common com = new Common();
		String url = Common.api + com.getPaths().get("auth");
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url + "?email=" + email + "&password=" + password + "&action=pair&country=ES&deviceId=sdafasdfasdf");

		//https://api.mobile.endomondo.com/mobile/auth?email=david.rodriguez@grupoonetec.com&password=Owyeah123&action=pair&country=GB&deviceId=sdafasdfasdf
		HttpResponse response = client.execute(request);
		
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		
		return responseString;
	}
}
