package logicaPrograma;

public class Producto {
	private String nombre;
	private double precio;
	private int cuantia;
	
	
	public Producto(String nombre, double precio, int cuantia){
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
	
}
