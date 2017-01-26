package excepciones;

public class InvalidCuentaException extends Exception {
	@Override
	public String getMessage(){
		return "Cuenta bancaria no válida.";
	}
}
