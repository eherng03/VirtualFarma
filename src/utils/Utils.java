package utils;

public class Utils {

	private static Utils utils;
	
	private Utils(){
		
	}
	
	public static Utils getUtils(){
		if(utils == null){
			utils = new Utils();
		}
		return utils;
	}
	
	public boolean checkCadenaLetrasNumerosOEspacios(String cadena){
		for(char caracter : cadena.toCharArray()){
			if(!(esEspacio(caracter) ||esNumero(caracter) || esLetraMayuscula(caracter) || esLetraMinuscula(caracter))){
				return false;
			}
		}
		return true;
	}
	
	public boolean checkDNI(String dni){
		char[] charDNI = dni.toCharArray();
		final String letra= "TRWAGMYFPDXBNJZSQVHLCKE";
		
		if(charDNI.length == 9){
			for(int i = 0; i < 8; i++){
				if(charDNI[i] < 48 || charDNI[i] > 58){
					return false;
				}
			}
			if(!esLetraMayuscula(charDNI[8])){
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
	
	public boolean checkCIF(String cif){
		char[] charCIF = cif.toCharArray();
		if(!esLetraMayuscula(charCIF[0])){
			return false;
		}
		if(charCIF.length != 9){
			return false;
		}
		for(int i = 1; i < charCIF.length; i++){
			if(!esNumero(charCIF[i])){
				return false;
			}
		}
		return true;
	}
	
	public boolean checkNumeroSS(String numeroSS){
		char[] charNumeroSSDNI = numeroSS.toCharArray();
		if(charNumeroSSDNI.length != 12){
			return false;
		}else{
			for(int i = 0; i < charNumeroSSDNI.length; i++){
				if(!esNumero(charNumeroSSDNI[i])){
					return false;
				}
			}
			return true;
		}
	}
	
	public boolean checkCuentaBancaria(String cuentaBancaria){
		char[] charCuenta = cuentaBancaria.toCharArray();
		if(!(esLetraMayuscula(charCuenta[0]) && esLetraMayuscula(charCuenta[1]))){
			return false;
		}
		if(charCuenta.length != 24){
			return false;
		}
		for(int i = 2; i < charCuenta.length; i++){
			if(!esNumero(charCuenta[i])){
				return false;
			}
		}
		return true;
	}
	
	public boolean checkTelefono(String telefono) {
		char[] charTelefono = telefono.toCharArray();
		if(telefono.length() != 9){
			return false;
		}
		for(char caracter : charTelefono){
			if(!esNumero(caracter)){
				return false;
			}
		}
		return true;
	}
	
	public boolean checkCPF(String cpf) {
		char[] charCPF = cpf.toCharArray();
		if(cpf.length() != 7){
			return false;
		}
		for(char caracter : charCPF){
			if(!esNumero(caracter)){
				return false;
			}
		}
		return true;
	}
	
	public boolean esLetra(char caracter){
		return esLetraMayuscula(caracter) || esLetraMinuscula(caracter);
	}
	
	public boolean esLetraMayuscula(char caracter){
		return caracter > 64 && caracter < 91;
	}
	
	public boolean esLetraMinuscula(char caracter){
		return caracter > 96 && caracter < 123;
	}
	
	public boolean esNumero(char caracter){
		return caracter > 47 && caracter < 58;
	}
	
	public boolean esEspacio(char caracter){
		return caracter == 32;
	}

}
