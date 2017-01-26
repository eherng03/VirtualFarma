package excepciones;

public class InvalidNameException extends Exception{
	@Override
	public String getMessage(){
		return "Su nombre y apellidos sólo pueden contener letras";
	}
}
