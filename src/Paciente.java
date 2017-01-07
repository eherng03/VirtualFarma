
public class Paciente {
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String DNI;
	private String numeroSS;
	private String contrasena;
	//Nombre y apellidos, DNI, número de la seguridad social  y contraseña
	
	public Paciente(String nombre, String apellido1, String apellido2, String DNI, String numeroSS, String contrasena){
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.DNI = DNI;
		this.numeroSS = numeroSS;
		this.contrasena = contrasena;
		BBDDPacientes.introducir(this);
	}

}
