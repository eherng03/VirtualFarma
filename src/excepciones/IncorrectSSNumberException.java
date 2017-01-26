package excepciones;

public class IncorrectSSNumberException extends Exception{

	@Override
	public String getMessage(){
		return "El número de la Seguridad Social es incorrecto";
	}

}
