package logicaPrograma;

import java.sql.SQLException;

import excepciones.InvalidCIFException;
import excepciones.InvalidCuentaException;
import excepciones.InvalidDNIException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidSSNumberException;
import excepciones.InvalidTelefoneException;

/**
 * Clase del administrador del sistema. Solo hay un administrador por lo que
 * es un singleton.
 * @author Alba y Eva.
 *
 */
public class Administrador {
	private final String user;
	private final String password;
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
			String email, String centroMedico, String password) throws InvalidNameException, InvalidDNIException, InvalidSSNumberException, InvalidPasswordException {
		Medico medico = new Medico(nombre, dni, numeroSS, direccion, email, centroMedico, password);
		
	}
	
	public void editarMedico(Medico medico) {
		// TODO Auto-generated method stub
		
	}
	
	public void eliminarMedico(Medico medico) {
		// TODO Auto-generated method stub
		
	}
	
	public void crearFarmacia(String nombre, String cif, String horario, String direccion, 
			String cuenta, String nombreDueno, String telefono, String email, String password) throws InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException, InvalidPasswordException, SQLException{
		Farmacia farmacia = new Farmacia(nombre, cif, horario, direccion, cuenta, nombreDueno, telefono, email, password);
	}

	public void editarFarmacia(String cif) {
		// TODO Auto-generated method stub
		
	}
	
	public void eliminarFarmacia(Farmacia farmacia) {
		// TODO Auto-generated method stub
		
	}

	public boolean checkPassword(String password) {
		return password.equals(this.password);
	}

	public boolean checkUser(String user) {
		return user.equals(this.user);
	}
	

}
