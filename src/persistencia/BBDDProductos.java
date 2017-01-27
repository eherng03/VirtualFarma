package persistencia;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import excepciones.InvalidPasswordException;
import logicaPrograma.Paciente;
import logicaPrograma.Producto;
import utils.Utils;

public class BBDDProductos {
	
	
	private static Connection conexion;
	private static BBDDProductos bbddProductos;
	private BBDDProductos(){}
	
//####################################################################################	
	
	public static void init(Connection conexion2) {
		conexion = conexion2;	
	}
	

	
	/**
	 * Devuelve la unica instancia de la clase, ya que es un singleton
	 * @return
	 */
	public static BBDDProductos getInstance(){
		if(bbddProductos == null){
			bbddProductos = new BBDDProductos();
		}
		return bbddProductos;
	}
	
	//----------------------------------INSERT-------------------------------------------
	
	/**
	 * Introduce un nuevo producto en la base de datos, comprobando antes si ya existe
	 * @param cif
	 * @param nombre
	 * @param precio
	 * @param cuantia
	 * @throws SQLException
	 */
	public void introducirProducto(String cif, String nombre, String precio, String cuantia) throws SQLException{
		String QuerySelect = "SELECT * FROM Productos WHERE Nombre = '" + nombre + "'";
        Statement stSelect = conexion.createStatement();
        java.sql.ResultSet resultSet;
        resultSet = stSelect.executeQuery(QuerySelect);
        if(resultSet.next() == true){
        	JOptionPane.showMessageDialog(null, "Los datos introducidos ya existen.");
        }else{
   	        String Query = "INSERT INTO Pacientes VALUES("
   	        			+ "\"" + cif + "\", "
   	                    + "\"" + nombre + "\", "
   	                    + "\"" + precio + "\", "
   	                    + "\"" + cuantia + "\")";
   	        Statement st = conexion.createStatement();
   	        st.executeUpdate(Query);
   	        JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa.");
        }	
	}
	
	//----------------------------------GET-------------------------------------------
	
	/**
	 * Devuelve un objeto Producto con los datos obtenidos de la base de datos
	 * @param nombre
	 * @return
	 * @throws SQLException 
	 */
	public Producto getProducto(String cif, String nombre) throws SQLException{
		Producto producto = null;
		String querySelect = "SELECT * FROM Productos WHERE CIF_Farmacia = '" + cif + "' AND Nombre = '" + nombre + "'";
		Statement stSelect = conexion.createStatement();
        java.sql.ResultSet resultSet;
        resultSet = stSelect.executeQuery(querySelect);
        
        while(resultSet.next()){
        	producto = new Producto(resultSet.getString("CIF_Farmacia"), resultSet.getString("Nombre"), resultSet.getDouble("Precio"), resultSet.getInt("Cuantia"));
        }
		return producto;
	}
	
	
	public void editarProducto(String cif, String nombre, String precio, String cuantia){
		
	}
	
	
	//----------------------------------DELETE-------------------------------------------
	
	/**
	 * Elimina el producto especificado de la base de datos
	 * @param cif
	 * @param nombre
	 * @throws SQLException
	 */
	public void eliminarProducto(String cif, String nombre) throws SQLException{
		String QuerySelect = "DELETE FROM Productos WHERE CIF_Farmacia = '" + cif + "' AND Nombre = '" + nombre + "'";
        Statement stSelect;
		stSelect = conexion.createStatement();
		stSelect.executeUpdate(QuerySelect);
	}
}
