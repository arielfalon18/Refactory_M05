
public class Vehicle {
	private String model;
	private String marca;
	private String categoria;
	
	public static final String Basic = "basic";
	public static final String Mitja = "mitja";
	public static final String Alt = "alt";
	public static final String GENERAL = "GENERAL";
	public static final String LUXE = "LUXE";
	
	Vehicle(String model, String marca, String categoria) {
		super();
		this.model = model;
		this.marca = marca;
		this.categoria = categoria;
	}
	//Creamos los get y set
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
