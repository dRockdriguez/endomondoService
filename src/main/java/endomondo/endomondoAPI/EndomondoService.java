package endomondo.endomondoAPI;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONObject;

import endomondo.endomondoAPI.model.User;
import endomondo.utils.Authentication;
import endomondo.utils.Workout;
import endomondo.utils.Workouts;
 
@Path("/endomondo")
public class EndomondoService {
	
	/* Obtiene el token de autenticación del usuario, entre otras cosas */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json; charset=utf-8")
	@Path("/login")
	public String login(User user) {
		JSONObject jsonRes = new JSONObject();
		Authentication a = new Authentication();
		try {
			/* Login con la api */
			String resAuth  = a.authenticate(user.getEmail(), user.getPassword());
			String [] aux = resAuth.split("\n");
			if (aux.length > 1) {
				jsonRes.put("status", aux[0]);
				jsonRes.put("authToken", aux[2].split("=")[1]);
				jsonRes.put("displayName", aux[4].split("=")[1]);
				jsonRes.put("userId", aux[5].split("=")[1]);
				jsonRes.put("secureToken", aux[7].split("=")[1]);
			} else {
				jsonRes.put("status", "ERROR");
				jsonRes.put("message", resAuth);
			}
		} catch (ClientProtocolException e) {
			jsonRes.put("status", "ERROR");
		} catch (IOException e) {
			jsonRes.put("status", "ERROR");
		}
		return jsonRes.toString();
	}
	
	/* Obtiene lista de los workouts del usuario */
	@GET
	@Produces("application/json; charset=utf-8")
	@Path("/workouts")
	public String workouts(@QueryParam("authToken") String authToken) {
		JSONObject jsonRes = new JSONObject();
		if (!"".equals(authToken) && null != authToken) {
			Workouts ws = new Workouts();
			try {
				String res = ws.getWorkouts(authToken);
				jsonRes = new JSONObject(res);
			} catch (ClientProtocolException e) {
				jsonRes.put("status", "ERROR");
			} catch (IOException e) {
				jsonRes.put("status", "ERROR");
			}
		} else {
			jsonRes.put("status", "ERROR");
			jsonRes.put("message", "authToken es obligatorio");
			
		}
		return jsonRes.toString();
	}
	
	/* Obtiene un workout concreto a través del id */
	@GET
	@Produces("application/json; charset=utf-8")
	@Path("/workout")
	public String workout(@QueryParam("authToken") String authToken, @QueryParam("workoutId") String workoutId) {
		JSONObject jsonRes = new JSONObject();
		if (!"".equals(authToken) && null != authToken && !"".equals(workoutId) && null != workoutId) {
			Workout ws = new Workout();
			try {
				String res = ws.getWorkout(authToken, workoutId);
				jsonRes = new JSONObject(res);
			} catch (ClientProtocolException e) {
				jsonRes.put("status", "ERROR");
			} catch (IOException e) {
				jsonRes.put("status", "ERROR");
			}
		} else {
			jsonRes.put("status", "ERROR");
			jsonRes.put("message", "authToken y workoutId son obligatorios");
			
		}
		return jsonRes.toString();
	}
	
	
	/* Obtiene el detalle de todos los workouts */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json; charset=utf-8")
	@Path("/all-workouts")
	public String allWorkouts(User user) {
		JSONObject jsonRes = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		Authentication a = new Authentication();
		try {
			/* Login con la api */
			String resAuth  = a.authenticate(user.getEmail(), user.getPassword());
			String [] aux = resAuth.split("\n");
			if (aux.length > 1) {
				Workouts ws = new Workouts();
				String res = ws.getWorkouts(aux[2].split("=")[1]);
				jsonRes = new JSONObject(res);
				JSONArray jsonArray = (JSONArray)jsonRes.get("data");
				Workout w = new Workout();
				for(int i = 0; i < jsonArray.length(); i ++) {
					if(((JSONObject)jsonArray.get(i)).get("id") != null) {
						JSONObject jsonWorkout = new JSONObject();
						String workout = w.getWorkout(aux[2].split("=")[1], ((JSONObject)jsonArray.get(i)).get("id").toString());
						jsonWorkout = new JSONObject(workout);
						jsonArr.put(jsonWorkout);
					}
				}
				jsonRes.put("workoutsNumber", jsonArr.length());
				if (jsonArr.length() > 0) {
					jsonRes.put("data", jsonArr);
				} else {
					jsonRes.put("data", "No hay workouts");
				}
			} else {
				jsonRes.put("status", "ERROR");
				jsonRes.put("message", resAuth);
			}
		} catch (ClientProtocolException e) {
			jsonRes.put("status", "ERROR");
		} catch (IOException e) {
			jsonRes.put("status", "ERROR");
		}
		return jsonRes.toString();
	}
}
