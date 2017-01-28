package logicaPrograma;

import java.sql.SQLException;

import excepciones.AlreadyExistException;
import excepciones.InvalidCIFException;
import excepciones.InvalidCuentaException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidTelefoneException;
import persistencia.BBDDFarmacias;
import utils.DataChecks;

/**
 * Clase que implementa los metodos que puede realizar un usuario farmacia
 * @author Eva y alba
 *
 */
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
	
	/**
	 * Constructor de la farmacia, si es nueva la introduce en la bbdd
	 * @param nombre
	 * @param cif
	 * @param horario
	 * @param direccion
	 * @param numeroCuenta
	 * @param nombreDueno
	 * @param telefono
	 * @param email
	 * @param password
	 * @param nuevo
	 * @throws InvalidNameException
	 * @throws InvalidCIFException
	 * @throws InvalidCuentaException
	 * @throws InvalidTelefoneException
	 * @throws InvalidPasswordException
	 * @throws SQLException
	 * @throws AlreadyExistException
	 */
	public Farmacia(String nombre, String cif, String horario, String direccion, 
			String numeroCuenta, String nombreDueno, String telefono, String email, String password, boolean nuevo) throws InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException, InvalidPasswordException, SQLException, AlreadyExistException {
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
			if(nuevo){
				BBDDFarmacias.getInstance().introducirFarmacia(cif, nombre, horario, direccion, numeroCuenta, nombreDueno, telefono, email, password);
			}
		}
	}

	/**
	 * Comprueba la estructura de los datos introducidos en la creacion de la farmacia
	 * @param nombre
	 * @param cif
	 * @param cuenta
	 * @param nombreDueno
	 * @param telefono
	 * @param password
	 * @return
	 * @throws InvalidNameException
	 * @throws InvalidCIFException
	 * @throws InvalidCuentaException
	 * @throws InvalidTelefoneException
	 * @throws InvalidPasswordException
	 */
	private boolean checkDatos(String nombre, String cif, String cuenta,
			String nombreDueno, String telefono, String password) throws InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException, InvalidPasswordException {
		if(!DataChecks.getInstance().checkCadenaLetrasNumerosOEspacios(nombre)){
			throw new InvalidNameException();
		}
		if(!DataChecks.getInstance().checkCIF(cif)){
			throw new InvalidCIFException();
		}
		if(!DataChecks.getInstance().checkCuentaBancaria(cuenta)){
			throw new InvalidCuentaException();
		}
		if(!DataChecks.getInstance().checkCadenaLetrasNumerosOEspacios(nombreDueno)){
			throw new InvalidNameException();
		}
		if(!DataChecks.getInstance().checkTelefono(telefono)){
			throw new InvalidTelefoneException();
		}
		if(!DataChecks.getInstance().checkCadenaLetrasNumerosOEspacios(password)){
			throw new InvalidPasswordException();
		}

		return true;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCIF() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getNombreDueno() {
		return nombreDueno;
	}

	public void setNombreDueno(String nombreDueno) {
		this.nombreDueno = nombreDueno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	@Override
	public String toString(){
		return nombre;
	}
}
