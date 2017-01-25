import Images.EmptyFieldException;

public class Paciente {
	
	private String nombre;
	private String dni;
	private String numeroSS;
	private String contrasena;
	//Nombre y apellidos, DNI, número de la seguridad social  y contraseña
	
	public Paciente(String nombre, String dni, String numeroSS, String contrasena) throws IncorrectPasswordException, EmptyFieldException, IncorrectSSNumberException, IncorrectDNIException{
		checkStruct(nombre, dni, numeroSS, contrasena);
		
		
		
		//TODO Capturar excepcion de si los datos ya existen
		BBDDPacientes.introducirPaciente(this);
	}

	private void checkStruct(String nombre, String dni, String numeroSS, String contrasena) throws EmptyFieldException, IncorrectPasswordException, IncorrectSSNumberException, IncorrectDNIException {
		if(nombre.equals("") || dni.equals("") || numeroSS.equals("") || contrasena.equals("")){
			throw new EmptyFieldException();
		}else{
			this.nombre = nombre;
		}
		
		
		if(!checkDNI(dni)){
			throw new IncorrectDNIException();
		}else{
			this.dni = dni;
		}
		
		if(!checkNumeroSS(numeroSS)){
			throw new IncorrectSSNumberException();
			
		}
		this.numeroSS = numeroSS;
		char[] charContrasena = contrasena.toCharArray();
		for(char caracter : charContrasena){
			//La contraseña solo puede ser alfanumérica
			if((caracter > 47 && caracter < 58) || (caracter > 64 && caracter < 91) || (caracter > 96 && caracter < 123)){
				this.contrasena = contrasena;
			}else{
				throw new IncorrectPasswordException();
			}
		}
		
	}

	private boolean checkNumeroSS(String numeroSS) {
		char[] charNumeroSSDNI = numeroSS.toCharArray();
		if(charNumeroSSDNI.length != 12){
			return false;
		}else{
			for(int i = 0; i < charNumeroSSDNI.length; i++){
				if(charNumeroSSDNI[i] < 64 || charNumeroSSDNI[i] > 91){
					return false;
				}
			}
			return true;
		}
	}

	private boolean checkDNI(String dni){
		char[] charDNI = dni.toCharArray();
		final String letra= "TRWAGMYFPDXBNJZSQVHLCKE";
		
		if(charDNI.length == 9){
			for(int i = 0; i < 8; i++){
				if(charDNI[i] < 47 || charDNI[i] > 58){
					return false;
				}
			}
			if(charDNI[8] < 64 || charDNI[8] > 91){
				return false;
			}else{
				Integer valor= new Integer(dni.substring(0, 8));
				int aux= valor%23;
				Character letraReal = charDNI[8];
				Character letraCalculada = letra.charAt(aux);
				if(letraReal==letraCalculada){
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}



	public void eliminar() {
		//TODO capturar excepcion de que no exista o no se elimine bien
		BBDDPacientes.eliminarPaciente(this);
		
	}

	

}
