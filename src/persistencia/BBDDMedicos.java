package persistencia;
import java.sql.Connection;

import logicaPrograma.Medico;

public class BBDDMedicos {

	private static Connection conexion;
	
	
	/**
	 * Todos los médicos se almacenaran en una única base de datos.
	 * Esta clase contendrá los métodos para almacenar, eliminar, modificar y ver los datos de los médicos
	 */
	public static Medico getMedico(String user, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void introducirMedico(String nombre, String dni, String cpf, String numeroSS, 
			String direccion, String email, String centroMedico, String password){
		
	}
	
	public static void editarMedico(String dni){
		
	}
	
	public static void eliminarMedico(String dni){
		
	}

	public static void init(Connection conexion2) {
		conexion = conexion2;	
	}


}
