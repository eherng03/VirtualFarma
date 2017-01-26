package persistencia;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import logicaPrograma.Paciente;

public class BBDDPacientes {
	
	
	 private static Connection conexion;
	
	/**
	 * Todos los pacientes se almacenarán en una única base de datos, esta clase contendrá los metodos para 
	 * interactuar con esta bbdd
	 */
	
	/**
	 * Accede a la bbdd y crea un objeto paciente con los datos obtenidos
	 * @param user
	 * @param password
	 */
	public static Paciente getPaciente(String user, String password) {
		return null;
		// TODO select where user & password...
	}

	/**
	 * Introduce los datos del paciente en la bbdd
	 * @param paciente
	 * @throws SQLException 
	 */
	public static void introducirPaciente(String nombre, String DNI, String numeroSS, String contrasena) throws SQLException {
		
		//TODO Seleccionar de la tabla de pacientes el que el dni coincida con el introducido
		String QuerySelect = "SELECT * FROM Pacientes WHERE DNI = " + DNI;
        Statement stSelect = conexion.createStatement();
        java.sql.ResultSet resultSet;
        resultSet = stSelect.executeQuery(QuerySelect);
        if(resultSet != null){
        	//TODO ya existen los datos
        }
		
		// TODO la contraseña no es valida
		 try {
	            String Query = "INSERT INTO Pacientes VALUES("
	                    + "\"" + DNI + "\", "
	                    + "\"" + nombre + "\", "
	                    + "\"" + numeroSS + "\", "
	                    + "\"" + contrasena + "\")";
	            Statement st = conexion.createStatement();
	            st.executeUpdate(Query);
	            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
	        }
		
	}
	
	public static void editarPaciente(String DNI) {
		// TODO Auto-generated method stub
		
	}
	
	public static void eliminarPaciente(String DNI) {
		// TODO comprobar dni en tabla pacientes y eliminar
		
	}
	

	public static void init(Connection conexion2) {
		conexion = conexion2;
	}

}