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
	
	/**
	 * Devuelve la unica instancia de la clase
	 * @return
	 */
	public static BBDDFarmacias getInstance(){
		if(bbddFarmacias != null){
			return bbddFarmacias;
		}
		bbddFarmacias = new BBDDFarmacias();
		return bbddFarmacias;
	}
	
	
	//-----------------------------------INSERT--------------------------------------------


	/**
	 * Introduce los datos del paciente en la bbdd
	 * @param paciente
	 * @throws SQLException 
	 * @throws InvalidPasswordException 
	 */
	public void introducirFarmacia(String cif, String nombre, String horario, String direccion, String numeroCuenta, String nombreDueno, String telefono, String email, String password) throws SQLException, InvalidPasswordException {
		
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
   	        
        }
	}
	
	
	//---------------------------------------GETS---------------------------------------

	/**
	 * Devuelve los datos almacenados en la base de datos del medico, a partir de usuario (CIF) y contraseña
	 * @param user
	 * @param password
	 * @return farmacia
	 * @throws InvalidNameException
	 * @throws InvalidCIFException
	 * @throws InvalidCuentaException
	 * @throws InvalidTelefoneException
	 * @throws InvalidPasswordException
	 * @throws SQLException
	 */
	public Farmacia getFarmacia(String user, String password) throws InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException, InvalidPasswordException, SQLException {
		String QuerySelect = "SELECT * FROM Farmacias WHERE CIF = '" + user + "' AND Password = '" + password + "'";	
		return devolverDatosFarmacia(QuerySelect);
	}
	

	/**
	 * Devuelve los datos almacenados en la base de datos del medico, a partir de usuario (CIF)
	 * @param cif
	 * @return farmacia
	 * @throws SQLException
	 * @throws InvalidNameException
	 * @throws InvalidCIFException
	 * @throws InvalidCuentaException
	 * @throws InvalidTelefoneException
	 * @throws InvalidPasswordException
	 */
	public Farmacia getFarmacia(String cif) throws SQLException, InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException, InvalidPasswordException  {
		String QuerySelect = "SELECT * FROM Farmacias WHERE CIF = '" + cif + "'";
		return devolverDatosFarmacia(QuerySelect);
	}
	

	
	//----------------------------------DELETE-------------------------------------------
	/**
	 * Elimina la farmacia de la base de datos que tenga el mismo cif que el introducido
	 * @param cif
	 * @throws SQLException
	 */
	public void eliminarFarmacia(String cif) throws SQLException{
		String query = "DELETE FROM Farmacias WHERE CIF = '" + cif + "'";
        Statement statement;
        statement = conexion.createStatement();
        statement.executeUpdate(query);
	}

	//----------------------------------UTILS-------------------------------------------
	/**
	 *  Ejecuta una Query sql que devuelve los datos de la farmacia almacenados en la tabla
	 * @param querySelect
	 * @return farmacia
	 * @throws SQLException
	 * @throws InvalidNameException
	 * @throws InvalidCIFException
	 * @throws InvalidCuentaException
	 * @throws InvalidTelefoneException
	 * @throws InvalidPasswordException
	 */
	private Farmacia devolverDatosFarmacia(String querySelect) throws SQLException, InvalidNameException, InvalidCIFException, InvalidCuentaException, InvalidTelefoneException, InvalidPasswordException {
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
