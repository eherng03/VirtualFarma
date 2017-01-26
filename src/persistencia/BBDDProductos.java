package persistencia;
import java.sql.Connection;

import logicaPrograma.Producto;

public class BBDDProductos {
	
	
	private static Connection conexion;

	/**
	 * Cada Farmacia almacenada en la bbdd de farmacias tendra su propia bbdd de productos.
	 * En esta clase van los metodos para añadir productos, eliminarlos, verlos etc
	 */
	
	public Producto getProducto(String nombre){
		return null;
		
	}
	
	public void introducirProducto(Producto producto){
		
	}
	
	public void editarProducto(Producto producto){
		
	}
	
	public void eliminarProducto(Producto producto){
		
	}
	
	public static void init(Connection conexion2) {
		conexion = conexion2;	
	}

}
