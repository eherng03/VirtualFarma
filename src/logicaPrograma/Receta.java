package logicaPrograma;

import java.sql.SQLException;

import excepciones.AlreadyExistException;
import persistencia.BBDDRecetas;

public class Receta {
	private String dniPaciente;
	private String dniMedico;
	private String nombreMedicamento;
	private boolean crónica;
	private String fecha;			//Fecha desde la que se puede adquirir el producto
	private String unidadesXToma;
	private String frecuencia;		//en horas
	private String duracion; 	//"2 semanas" "5 dias" "1 mes" etc.
	private String instrucciones;	//instrucciones especificas sobre como tomar el medicamento
	private String nEnvases;

	
	public Receta(String dniPacienteX, String dniMedicoX, String nombreMedicamento, boolean crónica, String fecha,
			String unidadesXToma, String frecuencia, String duracion, String instrucciones, String nEnvases, boolean nuevo) throws SQLException, AlreadyExistException{
		this.setDniPaciente(dniPacienteX);
		this.dniMedico = dniMedicoX;
		this.setNombreMedicamento(nombreMedicamento);
		this.setCrónica(crónica);
		this.setFecha(fecha);
		this.unidadesXToma = unidadesXToma;
		this.frecuencia = frecuencia;
		this.duracion = duracion;
		this.instrucciones = instrucciones;
		this.nEnvases = nEnvases;
		if(nuevo){
			BBDDRecetas.getInstance().introducirReceta(dniPaciente, dniMedico, nombreMedicamento, crónica, fecha, unidadesXToma, frecuencia, duracion, instrucciones, nEnvases);
		}
	}



	public String getDniPaciente() {
		return dniPaciente;
	}


	public void setDniPaciente(String dniPaciente) {
		this.dniPaciente = dniPaciente;
	}


	public String getNombreMedicamento() {
		return nombreMedicamento;
	}


	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public boolean isCrónica() {
		return crónica;
	}


	public void setCrónica(boolean crónica) {
		this.crónica = crónica;
	}

	
	
}
