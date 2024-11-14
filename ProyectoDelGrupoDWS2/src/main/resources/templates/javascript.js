//  document.getElementById("formulario").addEventListener("submit", function(event) {
//    event.preventDefault(); // Evita el envío tradicional del formulario
//
//    const formData = new FormData(this); // Recoge los datos del formulario
//
//    // Realiza una solicitud al controlador del proyecto web
//    fetch(this.action, {
//        method: this.method, // Usa el método POST definido en el formulario
//        body: new URLSearchParams(formData) // Convierte los datos del formulario a URL-encoded
//    })
//    .then(response => response.json()) // Convierte la respuesta a JSON
//    .then(data => {
//        if (data.success) { // Si el backend responde con éxito
//            window.location.href = "dashboard.html"; // Redirige a la página de éxito
//        } else {
//            alert("Credenciales inválidas"); // Muestra un mensaje de error
//        }
//    })
//    .catch(error => {
//        alert("Error de autenticación"); // Muestra un mensaje de error si la autenticación falla
//    });
//});