import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
public class Test_de_Proves{

	private Client client;
	private Vehicle basic;
	private Vehicle mitja;
	private Vehicle alt;
	private Lloguer lloguer;
	
	//Mensaje original
	private String textOriginal = "Informe de lloguers del client Ariel (26333408H)\n" + 
			"	nuevo ferrari: 90.0€\n" + 
			"	terreno 4X4: 495.0€\n" + 
			"	Nu  Renault: 720.0€\n" + 
			"Import a pagar: 1305.0€\n" + 
			"Punts guanyats: 5\n";
	
	
	
	//Mensaje de genereado por un dia antes 
	private String textGeneralUnDia = "Informe de lloguers del client Ariel (26333408H)\n" + 
			"	nuevo ferrari: 90.0€\n" +  
			"Import a pagar: 90.0€\n" + 
			"Punts guanyats: 1\n";
	
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");

	//Datos 
	@Before
	public void setUp() {
		client = new Client("26333408H", "Ariel", "123456789");
		basic = new Vehicle("ferrari","nuevo", Vehicle.Basic);
		mitja = new Vehicle("4X4", "terreno", Vehicle.Mitja);
		alt = new Vehicle("Renault", "Nu ", Vehicle.Alt);
	}
	
	
	//Tienes que poner un dia antes del 4
	@Test
	public void testGeneralUnDia() throws ParseException {
		Date fecha = dateFormat.parse("4/10/2014");
		lloguer = new Lloguer(fecha, 3, basic);
		client.afegeix(lloguer);

		System.out.println("textOriginalX abans de l'assert");
		assertEquals(textGeneralUnDia, client.informe());
	}
	
	
	
	
	//Llamamos al texto original
	@Test
	public void testBasic() throws ParseException {
		Date fecha = dateFormat.parse("2/8/2013");
		lloguer = new Lloguer(fecha, 2, basic);
		client.afegeix(lloguer);
		Date fecha2 = dateFormat.parse("8/9/2014");
		lloguer = new Lloguer(fecha2, 7, mitja);
		client.afegeix(lloguer);
		Date fecha3 = dateFormat.parse("4/10/2014"); 
		lloguer = new Lloguer(fecha3, 4, alt);
		client.afegeix(lloguer);
		System.out.println("Texti Origenal abans de l'assert");
		assertEquals(textOriginal, client.informe());
	}


}
