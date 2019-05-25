import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorLloguersLite {
	public static void main(String[] args) throws ParseException {
		// creamos un cliente
		Client client1 = new Client("26333408H", "Ariel", "123456789");

		//creamos los tres vehiculos
		Vehicle vehicleBasic = new Vehicle("ferrari", "nuevo", Vehicle.Basic);
		Vehicle vehicleMitja = new Vehicle("4X4", "terreno", Vehicle.Mitja);
		Vehicle vehicleAlt = new Vehicle("Renault", "Nu", Vehicle.Alt);

		//creamos tres alquileres
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = dateFormat.parse("2/8/2013");
		Lloguer lloguerBasic = new Lloguer(date, 2, vehicleBasic);
		Client.afegeix(lloguerBasic);

		Date date2 = dateFormat.parse("8/09/2014");
		Lloguer lloguerMitja = new Lloguer(date2, 7, vehicleMitja);
		Client.afegeix(lloguerMitja);

		Date date3 = dateFormat.parse("4/10/2014");
		Lloguer lloguerAlt = new Lloguer(date3, 4, vehicleAlt);
		Client.afegeix(lloguerAlt);

		//Formato de fecha
		System.out.println(dateFormat.format(lloguerBasic.getData()));
		System.out.println(dateFormat.format(lloguerMitja.getData()));
		System.out.println(dateFormat.format(lloguerAlt.getData()));

		//mostrar datos
		System.out.println(client1.informe());

	}
}
