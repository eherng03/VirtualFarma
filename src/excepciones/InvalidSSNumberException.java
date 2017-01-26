package excepciones;

public class InvalidSSNumberException extends Exception{

	@Override
	public String getMessage(){
		return "El número de la Seguridad Social es incorrecto";
	}

}
