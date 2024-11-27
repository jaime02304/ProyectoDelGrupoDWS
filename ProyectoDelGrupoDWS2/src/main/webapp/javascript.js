document.addEventListener("DOMContentLoaded", function () {
    // Seleccionar los botones del DOM
    const botonAdmin = document.querySelector(".botonAdmin");
    const linkLogin = document.querySelector(".linkLogin");

	console.log(esAdmin);
    if (esAdmin) {
        // Si es administrador, mostrar el botón de admin y ocultar el login
		botonAdmin.classList.remove("hidden");
		        linkLogin.classList.add("hidden"); 
    } else {
        // Si no es administrador, ocultar ambos botones
        botonAdmin.style.display = "none"; // Ocultar botón admin
        linkLogin.style.display = "none";  // Ocultar link de login
    }
});