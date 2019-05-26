
import java.util.Date;
import java.util.Vector;

public class Lloguer {
	private Date  data;
	private int dies;
	private Vehicle vehicle;
	private static final double cantidad_por_basic = 3;
	private static final double dias_iniciados = 3;
	private static final double euro_por_dias = 1.5;
	private static final double cantidad_por_mitja = 4;
	private static final double dias_iniciados_mitja = 2;
	private static final double euro_por_dias_mitja = 2.5;
	private static final double euro_por_dias_alt = 6;
	public Lloguer(Date date, int dies, Vehicle vehicle) {
		super();
		this.data = date;
		this.dies = dies;
		this.vehicle = vehicle;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getDies() {
		return dies;
	}
	public void setDies(int dies) {
		this.dies = dies;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public double precio_de_Vehiculo() {
		double precio = 0;
		switch (getVehicle().getCategoria()) {
		case Vehicle.Basic:
			precio += cantidad_por_basic;
			if (getDies() > dias_iniciados) {
				precio += (getDies() - cantidad_por_basic) * euro_por_dias;
			}
			break;
		case Vehicle.Mitja:
			precio += cantidad_por_mitja;
			if (getDies() > dias_iniciados_mitja) {
				precio += (getDies() - dias_iniciados_mitja) * euro_por_dias_mitja;
			}
			break;
		case Vehicle.Alt:
			precio += getDies() * euro_por_dias_alt;
			break;
		}
		return precio;
	}
	public int bonificaciondelloguer() {
    	//creamos la variable de 0 y contador que sume
		int bonificacions = 0;
		bonificacions++;
		//comprobamos si la categoria del vehicle es alto  y si sus dias son superior a un dia
		if (getVehicle().getCategoria() == Vehicle.Alt && getDies() > 1) {
			bonificacions++;
		}
		return bonificacions;
	}
	
}
