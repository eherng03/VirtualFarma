package logicaPrograma;

/**
 * Clase que encapsula los datos y funciones de los objetos Producto
 * @author Eva y Alba
 *
 */
public class Producto {
	private String nombre;
	private double precio;
	private int cuantia;
	private String cif;
	
	public Producto(String cif, String nombre, double precio, int cuantia, boolean nuevo){
		this.setCif(cif);
		this.nombre = nombre;
		this.precio = precio;
		this.cuantia = cuantia;
	}
	
	public int getCuantia() {
		return cuantia;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}
	
	@Override
	public String toString(){
		return nombre + " , " + precio + "€";
	}
	
}
