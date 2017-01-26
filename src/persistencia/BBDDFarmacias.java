package persistencia;
import java.sql.Connection;

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
	
	public void introducirFarmacia(Farmacia farmacia){
		
	}
	
	public void editarFarmacia(Farmacia farmacia){
		
	}
	
	public void eliminarFarmacia(Farmacia farmacia){
		
	}

	public static void init(Connection conexion2) {
		conexion = conexion2;	
	}

}
