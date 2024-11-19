package edu.ProyectoDelGrupoDWS2.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase que configura los metodos comunes o utilizados de manera frecuente 
 * @author jpribio - 19/11/24
 */
public class utilidades {
	/**
	 * Metodo privado que encripta la contraseña 
	 * @author amd - 17/11/24
	 * @param contra sin encriptar
	 * @return devuelve la contraseña encriptada
	 */
	public String encriptarContrasenia(String contra) {
		 try {
	           
	            MessageDigest objetoDigest = MessageDigest.getInstance("SHA-256");
	            // Calcula el hash de la contraseña
	            byte[] arrayDeBytes = objetoDigest.digest(contra.getBytes());
	            
	            // Convierte el byte array a un String hexadecimal
	            StringBuilder cadenaHexadecimal = new StringBuilder();
	            for (byte b : arrayDeBytes) {
	                String hexadecimal = Integer.toHexString(0xff & b);
	                if (hexadecimal.length() == 1) {
	                    cadenaHexadecimal.append('0');
	                }
	                cadenaHexadecimal.append(hexadecimal);
	            }
	            return cadenaHexadecimal.toString();
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
	}

}
