document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const usuario = {
        email: email,
        password: password
    };

    fetch("/api/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(usuario)
    })
    .then(response => response.json())
    .then(data => {
        if (data === "admin") {
            window.location.href = "/admin";
        } else if (data === "user") {
            window.location.href = "/user";
        } else {
            document.getElementById("error-message").innerText = "Credenciales inválidas";
        }
    })
    .catch(error => {
        console.error("Error:", error);
    });
});