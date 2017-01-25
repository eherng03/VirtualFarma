
public class Receta {
	private String nombrePaciente;
	private String nombreMedico;
	private String nombreMedicamento;
	private boolean crónica;
	private String fecha;			//Fecha desde la que se puede adquirir el producto
	private int unidadesXToma;
	private int frecuencia;		//en horas
	private String duracion; 	//"2 semanas" "5 dias" "1 mes" etc.
	private String instrucciones;	//instrucciones especificas sobre como tomar el medicamento
	private int nEnvases;

	
	public Receta(String nombrePaciente, String nombreMedico, String nombreMedicamento, boolean crónica, String fecha,
			int unidadesXToma, int frecuencia, String duracion, String instrucciones, int nEnvases) {
		this.nombrePaciente = nombrePaciente;
		this.nombreMedico = nombreMedico;
		this.nombreMedicamento = nombreMedicamento;
		this.crónica = crónica;
		this.fecha = fecha;
		this.unidadesXToma = unidadesXToma;
		this.frecuencia = frecuencia;
		this.duracion = duracion;
		this.instrucciones = instrucciones;
		this.nEnvases = nEnvases;
	}

	
	
}
