package persistencia;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
	public static Receta[] getRecetas(String dni) {
		//Todas las recetas
		return null;
		// TODO Auto-generated method stub
	}

	/**
	 * Introduce los datos de la receta en la bbdd
	 * @param paciente
	 * @throws SQLException 
	 * @throws AlreadyExistException 
	 */
	public static void introducirReceta(String dniPaciente, String dniMedico, String nombreMedicamento, boolean crónica, String fecha,
			int unidadesXToma, int frecuencia, String duracion, String instrucciones, int nEnvases) throws SQLException, AlreadyExistException {
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
   	                    + "\"" + crónica + "\", "
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
	
	public static void eliminarReceta(Receta receta) {
		// TODO Auto-generated method stub
		
	}

	
}
