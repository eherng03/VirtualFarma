package excepciones;

public class InvalidNameException extends Exception{
	@Override
	public String getMessage(){
		return "Nombre no válido.";
	}
}
