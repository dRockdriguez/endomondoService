# endomondoService
Microservicios creados con msf4j que conectan con la API de endomondo.
	- /login: Recibe email, password y deviceId. obtiene el authToken.
	- /workouts: Recibe el authToken y devuelve la lista de workouts del usuario.
	- /workout: Recibe el authToken y el id del workout y devuelve el detalle del workout.
	-/all-workouts: Recibe email, password y deviceId y devuelve una lista con el detalle de todos los workouts del usuario