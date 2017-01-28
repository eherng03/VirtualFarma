package logicaPrograma;

import java.sql.SQLException;

import excepciones.AlreadyExistException;
import persistencia.BBDDRecetas;

/**
 * Clase que encapsula los objetso receta, con todos sus métodos.
 * @author Eva y Alba
 *
 */
public class Receta {
	private String dniPaciente;
	private String dniMedico;
	private String nombreMedicamento;
	private String crónica;
	private String fecha;			//Fecha desde la que se puede adquirir el producto
	private String unidadesXToma;
	private String frecuencia;		//en horas
	private String duracion; 	//"2 semanas" "5 dias" "1 mes" etc.
	private String instrucciones;	//instrucciones especificas sobre como tomar el medicamento
	private String nEnvases;

	
	public Receta(String dniPacienteX, String dniMedicoX, String nombreMedicamento, String crónica, String fecha,
			String unidadesXToma, String frecuencia, String duracion, String instrucciones, String nEnvases, boolean nuevo) throws SQLException, AlreadyExistException{
		this.setDniPaciente(dniPacienteX);
		this.dniMedico = dniMedicoX;
		this.setNombreMedicamento(nombreMedicamento);
		this.setCrónica(crónica);
		this.setFecha(fecha);
		this.setUnidadesXToma(unidadesXToma);
		this.setFrecuencia(frecuencia);
		this.setDuracion(duracion);
		this.setInstrucciones(instrucciones);
		this.setnEnvases(nEnvases);
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
		return crónica == "true";
	}


	public void setCrónica(String crónica2) {
		this.crónica = crónica2;
	}
	
	@Override
	public String toString(){
		return nombreMedicamento + ", " + fecha;
	}



	public String getnEnvases() {
		return nEnvases;
	}



	public void setnEnvases(String nEnvases) {
		this.nEnvases = nEnvases;
	}



	public String getInstrucciones() {
		return instrucciones;
	}



	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}



	public String getUnidadesXToma() {
		return unidadesXToma;
	}



	public void setUnidadesXToma(String unidadesXToma) {
		this.unidadesXToma = unidadesXToma;
	}



	public String getFrecuencia() {
		return frecuencia;
	}



	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}



	public String getDuracion() {
		return duracion;
	}



	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	
	
}
