import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

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
		// TODO Auto-generated method stub
	}

	/**
	 * Introduce los datos del paciente en la bbdd
	 * @param paciente
	 */
	public static void introducirPaciente(String nombre, String DNI, String numeroSS, String contrasena) {
		//TODO Seleccionar de la tabla de pacientes el que el dni coincida con el introducido
		//String Query = "SELECT * FROM Paciente";
        //Statement st = conexion.createStatement();
        //java.sql.ResultSet resultSet;
        //resultSet = st.executeQuery(Query);
		
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
	
	public static void editarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		
	}
	
	public static void eliminarPaciente(Paciente paciente) {
		// TODO comprobar dni en tabla pacientes y eliminar
		
	}
	
	
	 public void insertData(String table_name, String ID, String name, String lastname, String age, String gender) {
	       
	 }

	public static void init(Connection conexion2) {
		conexion = conexion2;
	}

}
