# endomondoService
Microservicios creados con msf4j que conectan con la API de endomondo.<br><br>
	- /login: Recibe email, password y deviceId. obtiene el authToken.<br>
	- /workouts: Recibe el authToken y devuelve la lista de workouts del usuario.<br>
	- /workout: Recibe el authToken y el id del workout y devuelve el detalle del workout.<br>
	-/all-workouts: Recibe email, password y deviceId y devuelve una lista con el detalle de todos los workouts del usuario<br>