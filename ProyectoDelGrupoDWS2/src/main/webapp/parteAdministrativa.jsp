<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Pagina Administradora</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/cs.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<nav class="navegador2">
		<!-- Enlace a la página principal con Thymeleaf -->
		<a href="${pageContext.request.contextPath}/"> <svg
				xmlns="http://www.w3.org/2000/svg" width="60" height="60"
				fill="currentColor" class="bi bi-arrow-left-circle"
				viewBox="0 0 16 16">
                <path fill-rule="evenodd"
					d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-4.5-.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5z" />
            </svg>
		</a>
		<h1>ZONA ADMINISTRATIVA</h1>
	</nav>

	<main class="container w-100">
		<div class="row w-100 h-100 zonaA">

			<div class="col  zonaB ususarios">
				<h1 class="tituloUsuarios">USUARIOS</h1>
				<div class="contenedorUsuarios">
					<c:if test="${not empty listadoUsuarios}">
						<c:forEach var="alias" items="${listadoUsuarios}">
							<div class="contenidoUsuarios">
								<p class="alias">${alias}</p>
								<button class="eliminarUsu">Eliminar</button>
								<button class="modificarUsu">Modificar</button>
							</div>
						</c:forEach>
					</c:if>

					<!-- Si la lista está vacía, muestra un mensaje -->
					<c:if test="${empty listadoUsuarios}">
						<p style="color: black;">${error}</p>
					</c:if>

				</div>
				<button class="aniadirUsuario">AÑADIR USUARIO</button>
			</div>

			<div class="col zonaB club">
				<h1 class="tituloClub">CLUB</h1>
				<div class="contenedorClub">
					<div class="contenidoClub">
						<p class="alias">NOMBRE</p>
						<button class="eliminaClub">ELiminar</button>
						<button class="modificaClub">Modificar</button>
					</div>
					<div class="contenidoUsuarios">
						<p class="alias">NOMBRE</p>
						<button class="eliminaClub">ELiminar</button>
						<button class="modificaClub">Modificar</button>
					</div>
					<div class="contenidoUsuarios">
						<p class="alias">NOMBRE</p>
						<button class="eliminaClub">ELiminar</button>
						<button class="modificaClub">Modificar</button>
					</div>
					<div class="contenidoUsuarios">
						<p class="alias">NOMBRE</p>
						<button class="eliminaClub">ELiminar</button>
						<button class="modificaClub">Modificar</button>
					</div>
					<div class="contenidoUsuarios">
						<p class="alias">NOMBRE</p>
						<button class="eliminaClub">ELiminar</button>
						<button class="modificaClub">Modificar</button>
					</div>
					<div class="contenidoUsuarios">
						<p class="alias">NOMBRE</p>
						<button class="eliminaClub">ELiminar</button>
						<button class="modificaClub">Modificar</button>
					</div>
					<div class="contenidoUsuarios">
						<p class="alias">NOMBRE</p>
						<button class="eliminaClub">ELiminar</button>
						<button class="modificaClub">Modificar</button>
					</div>
					<div class="contenidoUsuarios">
						<p class="alias">NOMBRE</p>
						<p class="DNI">SEDE</p>
						<button class="eliminaClub">ELiminar</button>
						<button class="modificaClub">Modificar</button>
					</div>
					<div class="contenidoUsuarios">
						<p class="alias">NOMBRE</p>
						<button class="eliminaClub">ELiminar</button>
						<button class="modificaClub">Modificar</button>
					</div>
				</div>
				<button class="aniadirClub">AÑADIR CLUB</button>
			</div>
		</div>
	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

</body>
</html>
