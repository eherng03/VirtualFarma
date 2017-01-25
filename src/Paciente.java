
public class Paciente {
	
	private String nombre;
	private String DNI;
	private String numeroSS;
	private String contrasena;
	//Nombre y apellidos, DNI, número de la seguridad social  y contraseña
	
	public Paciente(String nombre,  String DNI, String numeroSS, String contrasena){
		this.nombre = nombre;
		this.DNI = DNI;
		this.numeroSS = numeroSS;
		this.contrasena = contrasena;
		
		//TODO Capturar excepcion de si los datos ya existen
		BBDDPacientes.introducirPaciente(this);
	}

	public void eliminar() {
		//TODO capturar excepcion de que no exista o no se elimine bien
		BBDDPacientes.eliminarPaciente(this);
		
	}

	

}
