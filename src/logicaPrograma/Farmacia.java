package logicaPrograma;

public class Farmacia {
	private String nombre;
	private String CIF;
	private String horarioApertura;
	private String direccion;
	private String cuentaBancaria;
	private String nombreDueno;
	private String telefonoDueno;
	private String email;
	private String password;
	
	public Farmacia(String nombre, String CIF, String horarioApertura, String direccion, String cuentaBancaria,
			String nombreDueno, String telefonoDueno, String email, String password) {
		this.nombre = nombre;
		this.CIF = CIF;
		this.horarioApertura = horarioApertura;
		this.direccion = direccion;
		this.cuentaBancaria = cuentaBancaria;
		this.nombreDueno = nombreDueno;
		this.telefonoDueno = telefonoDueno;
		this.email = email;
		this.password = password;
	}

}
