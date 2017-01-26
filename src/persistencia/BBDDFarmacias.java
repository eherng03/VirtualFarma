package persistencia;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import logicaPrograma.Farmacia;

public class BBDDFarmacias {

	
	private static Connection conexion;
	
	
	/**
	 * Cada farmacia será almacenada en esta base de datos.
	 *  Esta clase tendrálos metodos para añadir, eliminar y ver los datos de una farmacia
	 */

	public static Farmacia getFarmacia(String user, String password) {
		return null;
		// busca en la bbdd la farmacia con esos datos y la devuelve
		
	}
	
	/**
	 * Introduce los datos del paciente en la bbdd
	 * @param paciente
	 * @throws SQLException 
	 */
	public static void introducirFarmacia(String cif, String nombre, String horario, String direccion, String numeroCuenta, String nombreDueno, String telefono, String email, String password) throws SQLException {
		
		//TODO Seleccionar de la tabla de pacientes el que el dni coincida con el introducido
		String QuerySelect = "SELECT * FROM Farmacias WHERE CIF = " + cif;
        Statement stSelect = conexion.createStatement();
        java.sql.ResultSet resultSet;
        resultSet = stSelect.executeQuery(QuerySelect);
        if(resultSet != null){
        	 JOptionPane.showMessageDialog(null, "Los datos introducidos ya existen.");
        }else{
        	// TODO comprobar contraseña
   		 try {
   	            String Query = "INSERT INTO Farmacias VALUES("
   	                    + "\"" + cif + "\", "
   	                    + "\"" + nombre + "\", "
   	                    + "\"" + horario + "\", "
   	                    + "\"" + direccion + "\", "
   	                    + "\"" + numeroCuenta + "\", "
   	                    + "\"" + nombreDueno + "\", "
   	                    + "\"" + telefono + "\", "
   	                    + "\"" + email + "\", "
   	                    + "\"" + password + "\")";
   	            Statement st = conexion.createStatement();
   	            st.executeUpdate(Query);
   	            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
   	        } catch (SQLException ex) {
   	            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
   	        }
        }
		
		
	}
	
	public void editarFarmacia(String cif){
		
	}
	
	public void eliminarFarmacia(String cif){
		String QuerySelect = "DELETE FROM Pacientes WHERE CIF = " + cif;
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
