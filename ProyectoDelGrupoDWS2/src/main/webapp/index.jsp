<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- Enlace dinámico al CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/cs.css" />
<title>Landing Page</title>
</head>
<body>
	<nav class="navegador">
		<!-- Enlace dinámico a la página de administrador -->
		<form
			action="${pageContext.request.contextPath}/paginaAdministradora/recogerUsuarios"
			method="get" class="linkAdmin">
			<c:if test="${esAdmin}">
				<button type="submit" class="botonAdmin">ADMINISTRADORES</button>
			</c:if>
		</form>

		<!-- Enlace dinámico al login -->

		<a href="${pageContext.request.contextPath}/login" class="linkLogin"><c:if
				test="${!succes}">
				<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
					class="registroUsuario" width="60" height="60">
        <path
						d="M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-3.31 0-6 2.69-6 6v2h12v-2c0-3.31-2.69-6-6-6z" />
    </svg>
			</c:if> </a>
	</nav>

</body>
</html>
