# endomondoService
Microservicios creados con msf4j que conectan con la API de endomondo.<br><br>
	- <b>/login:</b> Recibe email, password y deviceId. Obtiene el authToken.<br>
	- <b>/workouts:</b> Recibe el authToken y devuelve la lista de workouts del usuario.<br>
	- <b>/workout:</b> Recibe el authToken y el id del workout y devuelve el detalle del workout.<br>
	- <b>/all-workouts:</b> Recibe email, password y deviceId y devuelve una lista con el detalle de todos los workouts del usuario<br>