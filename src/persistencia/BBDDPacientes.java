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

public class BBDDPacientes {
	
	
	 private static Connection conexion;
	
	/**
	 * Todos los pacientes se almacenarán en una única base de datos, esta clase contendrá los metodos para 
	 * interactuar con esta bbdd
	 */
	
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
		Paciente paciente = null;
		String QuerySelect = "SELECT * FROM Pacientes WHERE DNI = '" + user + "' AND Password = '" + password + "'";
        Statement stSelect = conexion.createStatement();
        java.sql.ResultSet resultSet;
        resultSet = stSelect.executeQuery(QuerySelect);
        
        while(resultSet.next()){
        	paciente = new Paciente(resultSet.getString("Nombre"), resultSet.getString("DNI"), resultSet.getString("NumeroSS"), resultSet.getString("Password"));
        }
		return paciente;
	}
	
	/**
	 * Accede a la bbdd y crea un objeto paciente con los datos obtenidos a partir del dni
	 * @param user
	 * @param password
	 * @throws SQLException 
	 * @throws InvalidNameException 
	 * @throws InvalidDNIException 
	 * @throws InvalidSSNumberException 
	 * @throws EmptyFieldException 
	 * @throws InvalidPasswordException 
	 */
	public static Paciente getPaciente(String dni) throws SQLException, InvalidPasswordException, EmptyFieldException, InvalidSSNumberException, InvalidDNIException, InvalidNameException {
		Paciente paciente = null;
		String QuerySelect = "SELECT * FROM Pacientes WHERE DNI = '" + dni + "'";
        Statement stSelect = conexion.createStatement();
        java.sql.ResultSet resultSet;
        resultSet = stSelect.executeQuery(QuerySelect);
        
        while(resultSet.next()){
        	paciente = new Paciente(resultSet.getString("Nombre"), resultSet.getString("DNI"), resultSet.getString("NumeroSS"), resultSet.getString("Password"));
        }
		return paciente;
	}

	/**
	 * Introduce los datos del paciente en la bbdd
	 * @param paciente
	 * @throws SQLException 
	 * @throws InvalidPasswordException 
	 */
	public static void introducirPaciente(String nombre, String DNI, String numeroSS, String password) throws SQLException, InvalidPasswordException {
		
		//TODO Seleccionar de la tabla de pacientes el que el dni coincida con el introducido
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
   		 try {
   	            String Query = "INSERT INTO Pacientes VALUES("
   	                    + "\"" + DNI + "\", "
   	                    + "\"" + nombre + "\", "
   	                    + "\"" + numeroSS + "\", "
   	                    + "\"" + password + "\")";
   	            Statement st = conexion.createStatement();
   	            st.executeUpdate(Query);
   	            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa.");
   	        } catch (SQLException ex) {
   	            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
   	        }
        }
		
		
		
	}
	
	public static void editarPaciente(String DNI) {
		// TODO Auto-generated method stub
		
	}
	
	public static void eliminarPaciente(String DNI) {
		
		String QuerySelect = "DELETE FROM Pacientes WHERE DNI = " + DNI;
        Statement stSelect;
		try {
			stSelect = conexion.createStatement();
			java.sql.ResultSet resultSet;
	        resultSet = stSelect.executeQuery(QuerySelect);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar los datos");
		}
        
		
	}
	

	public static void init(Connection conexion2) {
		conexion = conexion2;
	}

}
