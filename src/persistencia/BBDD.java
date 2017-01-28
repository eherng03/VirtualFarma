package persistencia;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


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
    
    /**
     * Inicializa la conexion con la base de datos y todos los controladores de las distintas tablas
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public BBDD makeBBDD() throws ClassNotFoundException, SQLException {

        	Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11155835", "sql11155835", "pfskdzCq1m");
           // System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
            BBDDPacientes.init(conexion);
            BBDDFarmacias.init(conexion);  
            BBDDMedicos.init(conexion);
            BBDDProductos.init(conexion);
            BBDDRecetas.init(conexion);
	        
	        database.conexion = conexion;
    	return database;
    }
 
    /**
     * Cierra la conexion con la base de datos remota
     */
    public void closeConnection() {
        try {
            conexion.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 

    /**
     * Crea una copiade seguridad local de la base de datos remota
     * @throws SQLException
     * @throws IOException 
     */
	public void copiaDeSeguridad() throws  IOException {
	
		Runtime runtime = Runtime.getRuntime();
		String directorio = System.getProperty("user.dir");

		Process child = runtime.exec(directorio + "\\mysqldump.exe -h sql11.freemysqlhosting.net --user=sql11155835 --password=pfskdzCq1m sql11155835");
		//Crear y escribir el fichero

		FileWriter writer = new FileWriter(directorio + "/backup/backup.sql");
		InputStreamReader inputReader = new InputStreamReader(child.getInputStream());
		BufferedReader bufferReader = new BufferedReader(inputReader);
		String linea;
		while( (linea = bufferReader.readLine()) != null ) {
			writer.write(linea + "\n");
		}
		writer.close();
		inputReader.close();
		bufferReader.close();
		JOptionPane.showMessageDialog(null, "El archivo se ha escrito correctamente.");
	}
}