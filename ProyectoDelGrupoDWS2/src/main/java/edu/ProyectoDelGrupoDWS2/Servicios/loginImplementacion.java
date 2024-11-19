package edu.ProyectoDelGrupoDWS2.Servicios;

import java.util.regex.Pattern;

public class loginImplementacion implements loginInterfaz {

	private Pattern email1 = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.(com|net|es)$"); //representa un patrón de expresión regular para luego compararla
	
	public boolean validarEmail(String email) {
		 if (email == null) {
			  return false; } 
			return email1.matcher(email).matches();
	}

}
