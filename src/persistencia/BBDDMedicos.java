package persistencia;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import logicaPrograma.Farmacia;
import logicaPrograma.Medico;

public class BBDDMedicos {

	private static Connection conexion;
	private static BBDDMedicos bbddMedicos;
	
	
	public static BBDDMedicos getInstance(){
		if(bbddMedicos != null){
			return bbddMedicos;
		}
		bbddMedicos = new BBDDMedicos();
		return bbddMedicos;
	}

	public static Medico getMedico(String user, String password) throws SQLException {
		String QuerySelect = "SELECT * FROM Medicos WHERE DNI = '" + user + "' AND Password = '" + password + "'";	
		return devolverDatosMedico(QuerySelect);
	}
	

	public static Medico getMedico(String user) throws SQLException {
		String QuerySelect = "SELECT * FROM Medicos WHERE DNI = '" + user + "'";	
		return devolverDatosMedico(QuerySelect);
	}
	
	



	public static void editarMedico(String dni){
		
	}
	
	public static void eliminarMedico(String dni){
		
	}

	public static void init(Connection conexion2) {
		conexion = conexion2;	
	}



	public static void introducirMedico(String nombre, String dni, String numeroSS, String direccion, String email,
			String centroMedico, String password) {
		// TODO Auto-generated method stub
		
	}
	
	
	private static Medico devolverDatosMedico(String querySelect) throws SQLException {
		Medico medico = null;
		Statement stSelect = conexion.createStatement();
	    java.sql.ResultSet resultSet;
	    resultSet = stSelect.executeQuery(querySelect);
	     /* TODO   
	    while(resultSet.next()){
	      medico = new Medico(resultSet.getString("Nombre"), resultSet.getString("CIF"), resultSet.getString("Horario"), resultSet.getString("Direccion"),
	      			resultSet.getString("NumeroCuenta"), resultSet.getString("NombreDueno"), resultSet.getString("Telefono"), resultSet.getString("email"), resultSet.getString("Password"));
	    }
		
		*/
	    return medico;
	}


}
