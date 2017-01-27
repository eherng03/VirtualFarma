package persistencia;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import excepciones.InvalidCIFException;
import excepciones.InvalidCuentaException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidTelefoneException;
import logicaPrograma.Farmacia;
import logicaPrograma.Paciente;
import utils.Utils;


/**
 * Cada farmacia será almacenada en esta base de datos.
 *  Esta clase tendrálos metodos para añadir, eliminar y ver los datos de una farmacia
 * @throws SQLException 
 * @throws InvalidPasswordException 
 * @throws InvalidTelefoneException 
 * @throws InvalidCuentaException 
 * @throws InvalidCIFException 
 * @throws InvalidNameException 
 */
public class BBDDFarmacias {

	
	private static Connection conexion;
	
	private static BBDDFarmacias bbddFarmacias;
	
	public static void init(Connection conexion2) {
		conexion = conexion2;	
	}
	
	
	public static BBDDFarmacias getInstance(){
		if(bbddFarmacias != null){
			return bbddFarmacias;
		}
		bbddFarmacias = new BBDDFarmacias();
		return bbddFarmacias;
	}
	
	//---------------------------------------GETS---------------------------------------


	public static Farmacia getFarmacia(String user, String password) throws InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException, InvalidPasswordException, SQLException {
		String QuerySelect = "SELECT * FROM Farmacias WHERE CIF = '" + user + "' AND Password = '" + password + "'";	
		return devolverDatosFarmacia(QuerySelect);
	}
	


	public static Farmacia getFarmacia(String cif) throws SQLException, InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException, InvalidPasswordException  {
		String QuerySelect = "SELECT * FROM Farmacias WHERE CIF = '" + cif + "'";
		return devolverDatosFarmacia(QuerySelect);
	}
	
	//-----------------------------------INSERT--------------------------------------------



	/**
	 * Introduce los datos del paciente en la bbdd
	 * @param paciente
	 * @throws SQLException 
	 * @throws InvalidPasswordException 
	 */
	public static void introducirFarmacia(String cif, String nombre, String horario, String direccion, String numeroCuenta, String nombreDueno, String telefono, String email, String password) throws SQLException, InvalidPasswordException {
		
		String QuerySelect = "SELECT * FROM Farmacias WHERE CIF = '" + cif + "'";
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
		//TODO 
	}
	
	public void eliminarFarmacia(String cif) throws SQLException{
		String QuerySelect = "DELETE FROM Pacientes WHERE CIF = '" + cif + "'";
        Statement stSelect;
		stSelect = conexion.createStatement();
		java.sql.ResultSet resultSet;
	    resultSet = stSelect.executeQuery(QuerySelect);
		
	}


	
	private static Farmacia devolverDatosFarmacia(String querySelect) throws SQLException, InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException, InvalidPasswordException {
		Farmacia farmacia = null;
		Statement stSelect = conexion.createStatement();
	    java.sql.ResultSet resultSet;
	    resultSet = stSelect.executeQuery(querySelect);
	        
	    while(resultSet.next()){
	      farmacia = new Farmacia(resultSet.getString("Nombre"), resultSet.getString("CIF"), resultSet.getString("Horario"), resultSet.getString("Direccion"),
	      			resultSet.getString("NumeroCuenta"), resultSet.getString("NombreDueno"), resultSet.getString("Telefono"), resultSet.getString("email"), resultSet.getString("Password"));
	    }
		return farmacia;
	}

}
