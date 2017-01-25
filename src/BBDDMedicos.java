import java.sql.Connection;

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
	
	public static void introducirMedico(Medico medico){
		
	}
	
	public static void editarMedico(Medico medico){
		
	}
	
	public static void eliminarMedico(Medico medico){
		
	}

	public static void init(Connection conexion2) {
		conexion = conexion2;	
	}


}
