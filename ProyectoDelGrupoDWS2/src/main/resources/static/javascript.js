document.getElementById("formulario").addEventListener("submit", function(event) {
	event.preventDefault(); // Evita el envío tradicional del formulario

	const formData = new FormData(this); // Recoge los datos del formulario

	// Realiza una solicitud al controlador del proyecto web
	fetch(this.action, {
		method: this.method, // Usa el método POST definido en el formulario
		body: new URLSearchParams(formData) // Convierte los datos del formulario a URL-encoded
	})
		.then(response => response.json()) // Convierte la respuesta a JSON
		.then(data => {
			if (data.success) { // Si la respuesta es exitosa
				if (data.isAdmin) { // Si es administrador
					window.location.href = "paginaAdministradora.html"; 
				} else { // Si es un usuario normal
					window.location.href = "index.html"; 
				}
			} else { // Si la respuesta tiene success: false
				alert(data.message || "Credenciales inválidas"); // Muestra el mensaje de error
			}
		})
		.catch(error => {
			alert("Error de autenticación"); // Muestra un mensaje de error si la autenticación falla
		});
});