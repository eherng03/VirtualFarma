package excepciones;

public class InvalidTelefoneException extends Exception{
	@Override
	public String getMessage(){
		return "Teléfono no válido.";
	}
}
