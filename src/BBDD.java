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
 
    private static Connection conexion;
    //private Statement statement = null;
    //private PreparedStatement preparedStatement = null;
    //private ResultSet resultSet = null;
    private static BBDD database;
 
    public static BBDD makeBBDD() {
    	if(database != null){
    		return database;
    	}else{
    		database = new BBDD();
    		
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	            conexion = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11154818", "sql11154818", "VI5cXvvBIk");
	            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
	            BBDDPacientes.init(conexion);
	            BBDDFarmacias.init(conexion);
	            
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
	            
	        }
	        
	        database.conexion = conexion;
			return database;
    	}
    }
 
    public void closeConnection() {
        try {
            conexion.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 

    public void insertData(String table_name, String ID, String name, String lastname, String age, String gender) {
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
                    + "\"" + ID + "\", "
                    + "\"" + name + "\", "
                    + "\"" + lastname + "\", "
                    + "\"" + age + "\", "
                    + "\"" + gender + "\")";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    }
 
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