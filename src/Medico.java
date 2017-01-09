
public class Medico {
	private String nombre;
	private String DNI;
	private String CPF;
	private String numeroSS;
	private String direccion;
	private String email;
	private String centroMedico;
	private String password;
	
	public Medico(String nombre, String DNI, String CPF, String numeroSS, String direccion, 
			String email, String centroMedico, String password){
		this.nombre = nombre;
		this.CPF = CPF;
		this.numeroSS = numeroSS;
		this.direccion = direccion;
		this.email = email;
		this.centroMedico = centroMedico;
		this.password = password;
	}

}
