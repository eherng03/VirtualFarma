package excepciones;

public class InvalidCIFException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage(){
		return "CIF no válido.";
	}
}
