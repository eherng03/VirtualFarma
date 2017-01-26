package logicaPrograma;

import excepciones.InvalidCIFException;
import excepciones.InvalidCuentaException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidTelefoneException;
import utils.Utils;

public class Farmacia {
	private String nombre;
	private String cif;
	private String horario;
	private String direccion;
	private String cuenta;
	private String nombreDueno;
	private String telefono;
	private String email;
	private String password;
	
	public Farmacia(String nombre, String cif, String horario, String direccion, 
			String cuenta, String nombreDueno, String telefono, String email, String password) throws InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException, InvalidPasswordException {
		if(checkDatos(nombre, cif, cuenta, nombreDueno, telefono, password)){
			this.nombre = nombre;
			this.cif = cif;
			this.horario = horario;
			this.direccion = direccion;
			this.cuenta = cuenta;
			this.nombreDueno = nombreDueno;
			this.telefono = telefono;
			this.email = email;
			this.password = password;
		}
		
	}

	private boolean checkDatos(String nombre, String cif, String cuenta,
			String nombreDueno, String telefono, String password) throws InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException, InvalidPasswordException {
		if(!Utils.getUtils().checkCadenaLetrasNumerosOEspacios(nombre)){
			throw new InvalidNameException();
		}
		if(!Utils.getUtils().checkCIF(cif)){
			throw new InvalidCIFException();
		}
		if(!Utils.getUtils().checkCuentaBancaria(cuenta)){
			throw new InvalidCuentaException();
		}
		if(!Utils.getUtils().checkCadenaLetrasNumerosOEspacios(nombreDueno)){
			throw new InvalidNameException();
		}
		if(telefono.length() != 9){
			throw new InvalidTelefoneException();
		}
		if(!Utils.getUtils().checkCadenaLetrasNumerosOEspacios(password)){
			throw new InvalidPasswordException();
		}

		return true;
	}

}
