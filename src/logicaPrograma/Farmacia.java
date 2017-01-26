package logicaPrograma;

import java.sql.SQLException;

import excepciones.InvalidCIFException;
import excepciones.InvalidCuentaException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidTelefoneException;
import persistencia.BBDDFarmacias;
import utils.Utils;

public class Farmacia {
	private String nombre;
	private String cif;
	private String horario;
	private String direccion;
	private String numeroCuenta;
	private String nombreDueno;
	private String telefono;
	private String email;
	private String password;
	
	public Farmacia(String nombre, String cif, String horario, String direccion, 
			String numeroCuenta, String nombreDueno, String telefono, String email, String password) throws InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException, InvalidPasswordException, SQLException {
		if(checkDatos(nombre, cif, numeroCuenta, nombreDueno, telefono, password)){
			this.nombre = nombre;
			this.cif = cif;
			this.horario = horario;
			this.direccion = direccion;
			this.numeroCuenta = numeroCuenta;
			this.nombreDueno = nombreDueno;
			this.telefono = telefono;
			this.email = email;
			this.password = password;
			BBDDFarmacias.introducirFarmacia(cif, nombre, horario, direccion, numeroCuenta, nombreDueno, telefono, email, password);
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
		if(!Utils.getUtils().checkTelefono(telefono)){
			throw new InvalidTelefoneException();
		}
		if(!Utils.getUtils().checkCadenaLetrasNumerosOEspacios(password)){
			throw new InvalidPasswordException();
		}

		return true;
	}

}
