package excepciones;

public class InvalidCIFException extends Exception {
	@Override
	public String getMessage(){
		return "CIF no válido.";
	}
}
