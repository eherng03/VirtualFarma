package excepciones;

public class InvalidCuentaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage(){
		return "Cuenta bancaria no válida.";
	}
}
