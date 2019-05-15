import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorLloguersLite {
	public static void main(String[] args) throws ParseException {
		//Tenemos un cliente
		Client cliente1= new Client("11111A", "Ariel", "+346666666");
		//Creamos los 3 tipos de vehiculo que existen
		Vehicle vehivulo1Baico= new Vehicle("Un model", "Una marca", Vehicle.Basic);
		Vehicle vehivulo2medio= new Vehicle("ModeloMedio", "MarcaNueva", Vehicle.Mitja);
		Vehicle vehivulo3alto= new Vehicle("ModeloAlto", "Gmaalta", Vehicle.Alt);
		//Creamos un los 3 lloguer para cada vehiculo
		//Para la fecha que estamos creando
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date fecha = dateFormat.parse("1/8/2013");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("d/M/yyyy");
		Date fecha2 = dateFormat2.parse("2/8/2013");
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("d/M/yyyy");
		Date fecha3 = dateFormat3.parse("3/8/2013");
		//Lloguer lugar1=new Lloguer(fecha, 2, vehivulo1);
		
		Lloguer lloger1B= new Lloguer(fecha, 2, vehivulo1Baico);
		Lloguer lloger1M= new Lloguer(fecha2, 2, vehivulo2medio);
		Lloguer lloger1A= new Lloguer(fecha3, 2, vehivulo3alto);
		
		//Añadimos los clientes a la base de datos 
		cliente1.afegeix(lloger1B);
		cliente1.afegeix(lloger1M);
		cliente1.afegeix(lloger1A);
		System.out.println(cliente1.informe());
		
	}
}
