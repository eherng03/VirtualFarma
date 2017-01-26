package persistencia;
import java.sql.Connection;

import logicaPrograma.Receta;

public class BBDDRecetas {
	
	
	
	private static Connection conexion;


	public static Receta[] getRecetas() {
		//Todas las recetas
		return null;
		// TODO Auto-generated method stub
	}

	/**
	 * Introduce los datos de la receta en la bbdd
	 * @param paciente
	 */
	public static void introducirReceta(Receta receta) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void eliminarReceta(Receta receta) {
		// TODO Auto-generated method stub
		
	}

	
	public static void init(Connection conexion2) {
		conexion = conexion2;	
	}
}
