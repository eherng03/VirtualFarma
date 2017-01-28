package logicaPrograma;

import java.sql.SQLException;

import excepciones.AlreadyExistException;
import excepciones.InvalidDNIException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidSSNumberException;
import persistencia.BBDDMedicos;
import utils.DataChecks;

/**
 * Clase que engloba los datos del medico y los metodos que este puede ejecutar
 * @author Eva y Alba
 *
 */
public class Medico {
	private String dni;
	private String numeroSS;
	private String direccion;
	private String email;
	private String centroMedico;
	private String password;
	
	public Medico(String nombre, String dni, String numeroSS, String direccion, 
			String email, String centroMedico, String password, boolean nuevo) throws InvalidNameException, InvalidDNIException, InvalidSSNumberException, InvalidPasswordException, SQLException, AlreadyExistException{
		if(checkDatos(nombre, dni, numeroSS, password)){
			this.nombre = nombre;
			this.dni = dni;
			this.numeroSS = numeroSS;
			this.direccion = direccion;
			this.email = email;
			this.centroMedico = centroMedico;
			this.password = password;
			if(nuevo){
				BBDDMedicos.getInstance().introducirMedico(nombre, dni, numeroSS, direccion, email, centroMedico, password);
			}
		}
	}

	/**
	 * Comprueba la estructura de los datos del medico
	 * @param nombre
	 * @param dni
	 * @param numeroSS
	 * @param password
	 * @return
	 * @throws InvalidNameException
	 * @throws InvalidDNIException
	 * @throws InvalidSSNumberException
	 * @throws InvalidPasswordException
	 */
	private boolean checkDatos(String nombre, String dni, String numeroSS, String password) throws InvalidNameException, InvalidDNIException, InvalidSSNumberException, InvalidPasswordException{
		if(!DataChecks.getInstance().checkCadenaLetrasNumerosOEspacios(nombre)){
			throw new InvalidNameException();
		}
		if(!DataChecks.getInstance().checkDNI(dni)){
			throw new InvalidDNIException();
		}

		if(!DataChecks.getInstance().checkNumeroSS(numeroSS)){
			throw new InvalidSSNumberException();
		}
		if(!DataChecks.getInstance().checkCadenaLetrasNumerosOEspacios(password)){
			throw new InvalidPasswordException();
		}
		return true;
	}
	
	private String nombre;
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDNI() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNumeroSS() {
		return numeroSS;
	}


	public void setNumeroSS(String numeroSS) {
		this.numeroSS = numeroSS;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCentroMedico() {
		return centroMedico;
	}


	public void setCentroMedico(String centroMedico) {
		this.centroMedico = centroMedico;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Comprueba que la contraseña del médico sea la misma que la pasada como parámetro
	 * @param password2
	 * @return true o false
	 */
	public boolean checkPassword(String password2) {
		return this.password.equals(password);
	}

}
