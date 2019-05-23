import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;

public class Lloguer {
	private Date  data;
	private int dies;
	private Vector<Vehicle> vehicles;
	Lloguer(Date data, int dies , Vehicle vehicle) {
		super();
		this.data = data;
		this.dies = dies;
		this.vehicles = new Vector<Vehicle>();
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
		return getVehicle();
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicles = vehicles;
	}
	
	
	
	
	
	
}
