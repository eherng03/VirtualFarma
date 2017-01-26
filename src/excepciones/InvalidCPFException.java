package excepciones;

public class InvalidCPFException extends Exception {
	@Override
	public String getMessage(){
		return "CPF no válido.";
	}
}
