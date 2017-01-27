package persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

/**
 * Clase que se encarga de crear la base de datos donde iran las tablas manejadas por las clases
 * bbdd farmacias, bbdd medicos, bbddpacientes, bbddproductos y bbdd recetas.
 * Tambien se encarga de la copia de seguridad.
 * @author Eva
 *
 */
 
public class BBDD {
 
    private Connection conexion;
    private static BBDD database;
    private BBDD(){}
    
  //####################################################################################	
    
    public static BBDD getInstance(){
    	if(database == null){
    		database = new BBDD();
    	}
    	return database;
    }
    
    public BBDD makeBBDD() throws ClassNotFoundException, SQLException {

        	Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11155835", "sql11155835", "pfskdzCq1m");
           // System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
            BBDDPacientes.init(conexion);
            BBDDFarmacias.init(conexion);  
	        
	        database.conexion = conexion;
    	return database;
    }
 
    public void closeConnection() {
        try {
            conexion.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
 
    /*
    public void getValues(String table_name) {
        try {
            String Query = "SELECT * FROM " + table_name;
            Statement st = conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
 
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("ID") + " "
                        + "Nombre: " + resultSet.getString("Nombre") + " " + resultSet.getString("Apellido") + " "
                        + "Edad: " + resultSet.getString("Edad") + " "
                        + "Sexo: " + resultSet.getString("Sexo"));
            }
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }
 */
    //Vale para todas
    public void deleteRecord(String table_name, String ID) {
        try {
            String Query = "DELETE FROM " + table_name + " WHERE ID = \"" + ID + "\"";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
        }
    }
 
}