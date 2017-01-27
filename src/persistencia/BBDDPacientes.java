package persistencia;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import excepciones.EmptyFieldException;
import excepciones.InvalidDNIException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidSSNumberException;
import logicaPrograma.Paciente;
import utils.Utils;


/**
 * Todos los pacientes se almacenarán en una única tabla de la base de datos, esta clase contendrá los metodos para 
 * interactuar con dicha tabla
 */
public class BBDDPacientes {
	
	
	private static Connection conexion;
	private static BBDDPacientes bbddPacientes;
	 
	public static void init(Connection conexion2) {
		conexion = conexion2;
	}
	
	/**
	 * Devuelve la unica instancia de la clase, ya que es un singleton
	 * @return
	 */
	public static BBDDPacientes getInstance(){
		if(bbddPacientes != null){
			return bbddPacientes;
		}
		bbddPacientes = new BBDDPacientes();
		return bbddPacientes;
	}

	
	//----------------------------------INSERT-------------------------------------------
	
	/**
	 * Introduce los datos del nuevo paciente en la base de datos, comprobando antes si estos ya existian
	 * @param nombre
	 * @param DNI
	 * @param numeroSS
	 * @param password
	 * @throws SQLException
	 * @throws InvalidPasswordException
	 */
	public static void introducirPaciente(String nombre, String DNI, String numeroSS, String password) throws SQLException, InvalidPasswordException {
		
		String QuerySelect = "SELECT * FROM Pacientes WHERE DNI = '" + DNI + "'";
        Statement stSelect = conexion.createStatement();
        java.sql.ResultSet resultSet;
        resultSet = stSelect.executeQuery(QuerySelect);
        if(resultSet.next() == true){
        	JOptionPane.showMessageDialog(null, "Los datos introducidos ya existen.");
        }else{
        	if(!Utils.getUtils().checkCadenaLetrasNumerosOEspacios(password)){
        		throw new InvalidPasswordException();
        	}
   	        String Query = "INSERT INTO Pacientes VALUES("
   	                    + "\"" + DNI + "\", "
   	                    + "\"" + nombre + "\", "
   	                    + "\"" + numeroSS + "\", "
   	                    + "\"" + password + "\")";
   	        Statement st = conexion.createStatement();
   	        st.executeUpdate(Query);
   	        JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa.");
        }		
	}
	
	
	//----------------------------------GETS-------------------------------------------
	
	/**
	 * Accede a la bbdd y crea un objeto paciente con los datos obtenidos mediante user(DNI) y password
	 * @param user
	 * @param password
	 * @throws SQLException 
	 * @throws InvalidNameException 
	 * @throws InvalidDNIException 
	 * @throws InvalidSSNumberException 
	 * @throws EmptyFieldException 
	 * @throws InvalidPasswordException 
	 */
	public static Paciente getPaciente(String user, String password) throws SQLException, InvalidPasswordException, EmptyFieldException, InvalidSSNumberException, InvalidDNIException, InvalidNameException {
		String QuerySelect = "SELECT * FROM Pacientes WHERE DNI = '" + user + "' AND Password = '" + password + "'";
		return devolverDatosPaciente(QuerySelect);
	}
	

	/**
	 * Accede a la bbdd y crea un objeto paciente con los datos obtenidos a partir del dni
	 * @param dni
	 * @return Paciente
	 * @throws SQLException
	 * @throws InvalidPasswordException
	 * @throws EmptyFieldException
	 * @throws InvalidSSNumberException
	 * @throws InvalidDNIException
	 * @throws InvalidNameException
	 */
	public static Paciente getPaciente(String dni) throws SQLException, InvalidPasswordException, EmptyFieldException, InvalidSSNumberException, InvalidDNIException, InvalidNameException {
		String QuerySelect = "SELECT * FROM Pacientes WHERE DNI = '" + dni + "'";
		return devolverDatosPaciente(QuerySelect);
	}


	//----------------------------------DELETE-------------------------------------------
	
	
	/**
	 * Método que elimina un paciente de la base de datos a partir de su dni
	 * @param DNI
	 * @throws SQLException
	 */
	public static void eliminarPaciente(String DNI) throws SQLException {
		String QuerySelect = "DELETE FROM Pacientes WHERE DNI = '" + DNI + "'";
        Statement stSelect;
		stSelect = conexion.createStatement();
		stSelect.executeUpdate(QuerySelect);
	}
	
	
	//----------------------------------UTILS-------------------------------------------
	
	/**
	 * Ejecuta una Query sql que devuelve los datos del paciente almacenados en la tabla
	 * @param querySelect
	 * @return Paciente
	 * @throws SQLException
	 * @throws InvalidPasswordException
	 * @throws EmptyFieldException
	 * @throws InvalidSSNumberException
	 * @throws InvalidDNIException
	 * @throws InvalidNameException
	 */
	private static Paciente devolverDatosPaciente(String querySelect) throws SQLException, InvalidPasswordException, EmptyFieldException, InvalidSSNumberException, InvalidDNIException, InvalidNameException {
		Paciente paciente = null;
		Statement stSelect = conexion.createStatement();
        java.sql.ResultSet resultSet;
        resultSet = stSelect.executeQuery(querySelect);
        
        while(resultSet.next()){
        	paciente = new Paciente(resultSet.getString("Nombre"), resultSet.getString("DNI"), resultSet.getString("NumeroSS"), resultSet.getString("Password"));
        }
		return paciente;
	}

	



}
