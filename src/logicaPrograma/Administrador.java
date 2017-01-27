package logicaPrograma;

import java.sql.SQLException;

import excepciones.AlreadyExistException;
import excepciones.InvalidCIFException;
import excepciones.InvalidCuentaException;
import excepciones.InvalidDNIException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidSSNumberException;
import excepciones.InvalidTelefoneException;
import interfazUsuario.WindowAdministrador;
import persistencia.BBDDFarmacias;
import persistencia.BBDDMedicos;

/**
 * Clase del administrador del sistema. Solo hay un administrador por lo que
 * es un singleton.
 * @author Alba y Eva.
 *
 */
public class Administrador {
	private final String user;
	private final String password;
	private WindowAdministrador windowAdministrador;
	private static Administrador admin;
	
	private Administrador(){
		user = "admin";
		password = "EvAlba";
		admin = this;
	}
	
	public static Administrador getAdmin(){
		if(admin == null){
			return new Administrador();
		}else{
			return admin;
		}
	}

	public String getPassword() {
		return password;
	}

	public String getUser() {
		return user;
	}

	public void crearMedico(String nombre, String dni, String numeroSS, String direccion, 
			String email, String centroMedico, String password) throws InvalidNameException, InvalidDNIException, InvalidSSNumberException, InvalidPasswordException, SQLException, AlreadyExistException {
		Medico medico = new Medico(nombre, dni, numeroSS, direccion, email, centroMedico, password);
		
	}
	
	public void editarMedico(Medico medico, String nombre, String dni, String numeroSS, String direccion, 
			String email, String centroMedico) throws InvalidPasswordException, SQLException, AlreadyExistException {
		eliminarMedico(medico);
		BBDDMedicos.getInstance().introducirMedico(nombre, dni, numeroSS, direccion, email, centroMedico, medico.getPassword());
		
	}
	
	public void eliminarMedico(Medico medico) throws SQLException {
		BBDDMedicos.getInstance().eliminarMedico(medico.getDNI());
		
	}
	
	public void crearFarmacia(String nombre, String cif, String horario, String direccion, 
			String cuenta, String nombreDueno, String telefono, String email, String password) throws InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException, InvalidPasswordException, SQLException, AlreadyExistException{
		Farmacia farmacia = new Farmacia(nombre, cif, horario, direccion, cuenta, nombreDueno, telefono, email, password);
	}

	public void editarFarmacia(Farmacia farmacia, String cif, String nombre, String horario, String direccion, String numeroCuenta, String nombreDueno, String telefono, String email) throws SQLException, InvalidPasswordException, AlreadyExistException {
		eliminarFarmacia(farmacia);
		BBDDFarmacias.getInstance().introducirFarmacia(cif, nombre, horario, direccion, numeroCuenta, nombreDueno, telefono, email, farmacia.getPassword());
	}
	
	public void eliminarFarmacia(Farmacia farmacia) throws SQLException {
		BBDDFarmacias.getInstance().eliminarFarmacia(farmacia.getCIF());
		
	}

	public boolean checkPassword(String password) {
		return password.equals(this.password);
	}

	public boolean checkUser(String user) {
		return user.equals(this.user);
	}
	

}
