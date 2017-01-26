package logicaPrograma;

import excepciones.InvalidDNIException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidSSNumberException;
import persistencia.BBDDMedicos;
import utils.Utils;

public class Medico {
	private String nombre;
	private String dni;
	private String numeroSS;
	private String direccion;
	private String email;
	private String centroMedico;
	private String password;
	
	public Medico(String nombre, String dni, String numeroSS, String direccion, 
			String email, String centroMedico, String password) throws InvalidNameException, InvalidDNIException, InvalidSSNumberException, InvalidPasswordException{
		if(checkDatos(nombre, dni, numeroSS, password)){
			this.nombre = nombre;
			this.dni = dni;
			this.numeroSS = numeroSS;
			this.direccion = direccion;
			this.email = email;
			this.centroMedico = centroMedico;
			this.password = password;
			
			BBDDMedicos.introducirMedico(nombre, dni, numeroSS, direccion, email, centroMedico, password);
		}
		
	}

	
	private boolean checkDatos(String nombre, String dni, String numeroSS, String password) throws InvalidNameException, InvalidDNIException, InvalidSSNumberException, InvalidPasswordException{
		if(!Utils.getUtils().checkCadenaLetrasNumerosOEspacios(nombre)){
			throw new InvalidNameException();
		}
		if(!Utils.getUtils().checkDNI(dni)){
			throw new InvalidDNIException();
		}

		if(!Utils.getUtils().checkNumeroSS(numeroSS)){
			throw new InvalidSSNumberException();
		}
		if(!Utils.getUtils().checkCadenaLetrasNumerosOEspacios(password)){
			throw new InvalidPasswordException();
		}
		return true;
	}
}
