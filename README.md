# Servicio API Endomondo
Microservicios creados con msf4j que conectan con la API de endomondo.<br><br>
	- <b>/login:</b> Recibe email, password y deviceId. Obtiene el authToken.<br>
		<br>POST:<br>
		<pre>
			{
				"email": "",
				"password": "",
				"deviceId": ""
			}
		</pre>
	- <b>/workouts:</b> Recibe el authToken y devuelve la lista de workouts del usuario.<br>
		<br>GET:<br>
		<pre>
			URL?authToken=_____
		</pre>
	- <b>/workout:</b> Recibe el authToken y el id del workout y devuelve el detalle del workout.<br>
		<br>GET:<br>
		<pre>
			URL?authToken=______&workoutId=_____
		</pre>
	- <b>/all-workouts:</b> Recibe email, password y deviceId y devuelve una lista con el detalle de todos los workouts del usuario<br>
		<br>POST:<br>
		<pre>
			{
				"email": "",
				"password": "",
				"deviceId": ""
			}
		</pre>