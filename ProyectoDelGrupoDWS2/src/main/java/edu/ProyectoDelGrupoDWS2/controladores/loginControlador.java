package edu.ProyectoDelGrupoDWS2.controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;

import edu.ProyectoDelGrupoDWS2.Dtos.UsuariosDto;
import edu.ProyectoDelGrupoDWS2.Servicios.loginImplementacion;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;

@RestController
@RequestMapping("/login")
public class loginControlador {

    @Autowired
    private loginImplementacion metodosLogin;

    @GET
    public ModelAndView login() {
        return new ModelAndView("login"); // Renderiza la página de login
    }

    @POST
    public ModelAndView metodoDeLoguearse(@ModelAttribute UsuariosDto usuarios) {
        try {
            // Usar ResponseEntity<?> para manejar respuestas de cualquier tipo
            ResponseEntity<?> respuestaEntity = metodosLogin.enviarDatosLogin(usuarios);

            // Verificar si la respuesta contiene un mapa
            if (respuestaEntity.getBody() instanceof Map<?, ?>) {
                Map<String, Object> cuerpo = (Map<String, Object>) respuestaEntity.getBody();

                // Verificar si el mapa contiene las claves necesarias
                if (cuerpo != null && cuerpo.containsKey("success") && cuerpo.containsKey("isAdmin")) {
                    boolean success = (Boolean) cuerpo.get("success");
                    boolean isAdmin = (Boolean) cuerpo.get("isAdmin");
                    String message = (String) cuerpo.get("message");

                    // Lógica de control
                    if (success) {
                        // Si es admin, redirigir a la página de admin
                        if (isAdmin) {
                            return new ModelAndView("paginaAdministradora");
                        } else {
                            return new ModelAndView("index"); // Página de usuario
                        }
                    } else {
                        // Si la operación no fue exitosa, devolver el mensaje de error
                        return new ModelAndView("login").addObject("error", message);
                    }
                }
            } else if (respuestaEntity.getBody() instanceof JsonNode) {
                // Si el cuerpo es un JsonNode (si el servidor responde con un JSON)
                JsonNode body = (JsonNode) respuestaEntity.getBody();

                // Verificar si el JSON contiene las claves necesarias
                if (body != null && body.has("success") && body.has("isAdmin")) {
                    boolean success = body.get("success").asBoolean();
                    boolean isAdmin = body.get("isAdmin").asBoolean();
                    String message = body.has("message") ? body.get("message").asText() : "Sin mensaje";

                    // Lógica de control
                    if (success) {
                        if (isAdmin) {
                            return new ModelAndView("adminPage"); // Página de administrador
                        } else {
                            return new ModelAndView("userPage"); // Página de usuario
                        }
                    } else {
                        // Si la operación no fue exitosa, devolver el mensaje de error
                        return new ModelAndView("login").addObject("error", message);
                    }
                }
            }

            // Si la respuesta no tiene el formato esperado, devolver el login con un mensaje de error
            return new ModelAndView("login").addObject("error", "Respuesta malformada del servidor");

        } catch (Exception e) {
            // En caso de excepción, devolver el login con un mensaje de error
            return new ModelAndView("login").addObject("error", "Error en el proceso de login");
        }
    }
}
