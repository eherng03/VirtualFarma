package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import excepciones.AlreadyExistException;
import logicaPrograma.Receta;

public class BBDDRecetas {
	
	private static Connection conexion;
	private static BBDDRecetas bbddRecetas;
	private BBDDRecetas(){}
	
//####################################################################################	
	
	public static BBDDRecetas getInstance(){
		if(bbddRecetas == null){
			bbddRecetas = new BBDDRecetas();
		}
		return bbddRecetas;
	}

	public static void init(Connection conexion2) {
		conexion = conexion2;	
	}

	//TODO
	public DefaultListModel<Receta> getRecetas(String dni) throws SQLException, AlreadyExistException {
		DefaultListModel<Receta> lista = new DefaultListModel<>();
		String querySelect = "SELECT * FROM Recetas WHERE DNI = '" + dni + "'";
		Statement stSelect = conexion.createStatement();
        java.sql.ResultSet resultSet;
        resultSet = stSelect.executeQuery(querySelect);
        
        while(resultSet.next()){
        	lista.addElement(new Receta(resultSet.getString("DNI_Paciente"), resultSet.getString("DNI_Medico"), resultSet.getString("NombreMedicamento"), 
        			resultSet.getBoolean("Cronica"), resultSet.getString("Fecha"), resultSet.getString("UnidadesToma"), resultSet.getString("Frecuencia") ,
        			resultSet.getString("Duracion"), resultSet.getString("Instrucciones"), resultSet.getString("NumEnvases"),  false));
        }
        return lista;
	}

	/**
	 * Introduce los datos de la receta en la bbdd
	 * @param paciente
	 * @throws SQLException 
	 * @throws AlreadyExistException 
	 */
	public void introducirReceta(String dniPaciente, String dniMedico, String nombreMedicamento, boolean crónica, String fecha,
			String unidadesXToma, String frecuencia, String duracion, String instrucciones, String nEnvases) throws SQLException, AlreadyExistException {
		String QuerySelect = "SELECT * FROM Recetas WHERE DNI_Paciente = '" + dniPaciente + "' AND DNI_Medico = '" + dniMedico + "' AND Nombre = '" 
			+ nombreMedicamento + "' AND Fecha = '" + fecha + "'";
        Statement stSelect = conexion.createStatement();
        java.sql.ResultSet resultSet;
        resultSet = stSelect.executeQuery(QuerySelect);
        if(resultSet.next() == true){
        	throw new AlreadyExistException();
        }else{
   	        String Query = "INSERT INTO Recetas VALUES("
   	        			+ "\"" + dniPaciente + "\", "
   	                    + "\"" + dniMedico + "\", "
   	                    + "\"" + nombreMedicamento + "\", "
   	                    + "\'" + crónica + "\', "
   	                    + "\"" + fecha + "\", "
   	                    + "\"" + unidadesXToma + "\", "
   	                    + "\"" + frecuencia + "\", "
   	                    + "\"" + duracion + "\", "
   	                    + "\"" + instrucciones + "\", "
   	                    + "\"" + nEnvases + "\")";
   	        Statement st = conexion.createStatement();
   	        st.executeUpdate(Query);
   	        JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa.");
        }
	}
	
	
	//----------------------------------DELETE-------------------------------------------
	

	public void eliminarReceta(String dniPaciente, String nombreMedicamento, String fecha) throws SQLException {
		String QuerySelect = "DELETE FROM Recetas WHERE DNI_Paciente = '" + dniPaciente + "' AND NombreMedicamento = '" + nombreMedicamento 
				+ "' AND Fecha = '" + fecha + "'";
        Statement stSelect;
		stSelect = conexion.createStatement();
		stSelect.executeUpdate(QuerySelect);
		
	}



	
}
