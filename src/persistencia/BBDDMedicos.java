package persistencia;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import excepciones.InvalidDNIException;
import excepciones.InvalidNameException;
import excepciones.InvalidPasswordException;
import excepciones.InvalidSSNumberException;
import logicaPrograma.Medico;
import utils.Utils;

public class BBDDMedicos {

	private static Connection conexion;
	private static BBDDMedicos bbddMedicos;
	private BBDDMedicos(){}
	
//####################################################################################
	
	public static void init(Connection conexion2) {
		conexion = conexion2;	
	}
	
	/**
	 * Devuelve la unica instancia de la clase
	 * @return
	 */
	public static BBDDMedicos getInstance(){
		if(bbddMedicos == null){
			bbddMedicos = new BBDDMedicos();
		}
		return bbddMedicos;
	}

	
	//----------------------------------INSERT-------------------------------------------

	/**
	 * Introduce un nuevo medico en la base de datos, comprobando antes que no exista uno con los mismos datos
	 * @param nombre
	 * @param dni
	 * @param numeroSS
	 * @param direccion
	 * @param email
	 * @param centroMedico
	 * @param password
	 * @throws InvalidPasswordException
	 * @throws SQLException
	 */
	public void introducirMedico(String nombre, String dni, String numeroSS, String direccion, String email,
			String centroMedico, String password) throws InvalidPasswordException, SQLException {

		String QuerySelect = "SELECT * FROM Medicos WHERE DNI = '" + dni + "'";
        Statement stSelect = conexion.createStatement();
        java.sql.ResultSet resultSet;
        resultSet = stSelect.executeQuery(QuerySelect);
        if(resultSet.next() == true){
        	 JOptionPane.showMessageDialog(null, "Los datos introducidos ya existen.");
        }else{
        	if(!Utils.getUtils().checkCadenaLetrasNumerosOEspacios(password)){
        		throw new InvalidPasswordException();
        	}
   
            String Query = "INSERT INTO Medicos VALUES("
                    + "\"" + dni + "\", "
                    + "\"" + nombre + "\", "
                    + "\"" + numeroSS + "\", "
                    + "\"" + direccion + "\", "
                    + "\"" + email + "\", "
                    + "\"" + centroMedico + "\", "
                    + "\"" + password + "\")";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
   	 
        }
		
	}
	
	//----------------------------------GETS-------------------------------------------
	
	/**
	 * Devuelve los datos almacenados en la base de datos del medico, a partir de usuario (DNI) y contraseña
	 * @param user
	 * @param password
	 * @return medico
	 * @throws SQLException
	 * @throws InvalidNameException
	 * @throws InvalidDNIException
	 * @throws InvalidSSNumberException
	 * @throws InvalidPasswordException
	 */
	public Medico getMedico(String user, String password) throws SQLException, InvalidNameException, InvalidDNIException, InvalidSSNumberException, InvalidPasswordException {
		String QuerySelect = "SELECT * FROM Medicos WHERE DNI = '" + user + "' AND Password = '" + password + "'";	
		return devolverDatosMedico(QuerySelect);
	}
	

	/**
	 * Devuelve los datos almacenados en la base de datos del medico, a partid de usuario (DNI)
	 * @param user
	 * @param password
	 * @return medico
	 * @throws SQLException
	 * @throws InvalidNameException
	 * @throws InvalidDNIException
	 * @throws InvalidSSNumberException
	 * @throws InvalidPasswordException
	 */
	public Medico getMedico(String user) throws SQLException, InvalidNameException, InvalidDNIException, InvalidSSNumberException, InvalidPasswordException {
		String QuerySelect = "SELECT * FROM Medicos WHERE DNI = '" + user + "'";	
		return devolverDatosMedico(QuerySelect);
	}
		
	
	//----------------------------------DELETE-------------------------------------------
	
	/**
	 * Elimina un médico concreto de la base de datos a partir de su dni
	 * @param dni
	 * @throws SQLException
	 */
	public void eliminarMedico(String dni) throws SQLException{
		String query = "DELETE FROM Medicos WHERE DNI = '" + dni + "'";
        Statement statement;
        statement = conexion.createStatement();
        statement.executeUpdate(query);
	}

	
	//----------------------------------UTILS-------------------------------------------
	
	/**
	 * Ejecuta una Query sql que devuelve los datos del medico almacenados en la tabla
	 * @param querySelect
	 * @return medico
	 * @throws SQLException
	 * @throws InvalidNameException
	 * @throws InvalidDNIException
	 * @throws InvalidSSNumberException
	 * @throws InvalidPasswordException
	 */
	private Medico devolverDatosMedico(String querySelect) throws SQLException, InvalidNameException, InvalidDNIException, InvalidSSNumberException, InvalidPasswordException {
		Medico medico = null;
		Statement stSelect = conexion.createStatement();
	    java.sql.ResultSet resultSet;
	    resultSet = stSelect.executeQuery(querySelect);
	    
	    while(resultSet.next()){
	      medico = new Medico(resultSet.getString("Nombre"), resultSet.getString("CIF"), resultSet.getString("Horario"), resultSet.getString("Direccion"),
	      			resultSet.getString("NumeroCuenta"), resultSet.getString("NombreDueno"), resultSet.getString("Telefono"));
	    }
	    return medico;
	}


}
