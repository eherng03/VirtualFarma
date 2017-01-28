package logicaPrograma;
import java.sql.SQLException;

import excepciones.AlreadyExistException;
import excepciones.EmptyFieldException;
import excepciones.InvalidDNIException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidSSNumberException;
import excepciones.InvalidNameException;
import persistencia.BBDDPacientes;
import utils.Utils;

public class Paciente {
	
	private String nombre;
	private String dni;
	private String numeroSS;
	private String password;


	
	//Nombre y apellidos, DNI, número de la seguridad social  y contraseña
	
	public Paciente(String nombre, String dni, String numeroSS, String password, boolean nuevo) throws InvalidPasswordException, EmptyFieldException, InvalidSSNumberException, InvalidDNIException, InvalidNameException, SQLException, AlreadyExistException{
		if(checkStruct(nombre, dni, numeroSS, password)){
			this.dni = dni;
			this.setNombre(nombre);
			this.setNumeroSS(numeroSS);
			this.password = password;
		}
		if(nuevo){
			BBDDPacientes.getInstance().introducirPaciente(nombre, dni, numeroSS, password);
		}
	}

	private boolean checkStruct(String nombre, String dni, String numeroSS, String password) throws EmptyFieldException, InvalidPasswordException, InvalidSSNumberException, InvalidDNIException, InvalidNameException {
		if(nombre.equals("") || dni.equals("") || numeroSS.equals("") || password.equals("")){
			throw new EmptyFieldException();
		}
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



	public void eliminar() throws SQLException {
		BBDDPacientes.getInstance().eliminarPaciente(this.dni);
		
	}

	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}

	public String getNumeroSS() {
		return numeroSS;
	}

	public void setNumeroSS(String numeroSS) {
		this.numeroSS = numeroSS;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
