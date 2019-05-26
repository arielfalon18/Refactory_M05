import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

public class Client {
    private String nif;
    private String nom;
    private String telefon;
    private static Vector<Lloguer> lloguers;
    private static final double EUROS_PER_UNITAT_DE_COST = 30;
    //Realizamos el constructor de la clase
    public Client(String nif, String nom, String telefon) {
		super();
		this.nif = nif;
		this.nom = nom;
		this.telefon = telefon;
		this.lloguers = new Vector<Lloguer>();
	}

    public String getNif()     { return nif;     }
    public String getNom()     { return nom;     }
    public String getTelefon() { return telefon; }

    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public static void afegeix(Lloguer lloguer) {
    	if (!lloguers.contains(lloguer)) {
    		lloguers.add(lloguer);
    	}
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }

    public String informe() {
        
        String resultat = "Informe de lloguers del client " +
            getNom() +
            " (" + getNif() + ")\n";
        for (Lloguer lloguer: lloguers) {
        	
            // afegeix lloguers freqüents
        	//ya no lo necesitamos ya que tenemos una funcion que lo hace
            //bonificacions ++;
        	//bonificaciondelloguer(lloguer);
        	//bonificacions+= lloguer.bonificaciondelloguer();

           

            // composa els resultats d'aquest lloguer
            resultat += "\t" +
                lloguer.getVehicle().getMarca() +
                " " +
                lloguer.getVehicle().getModel() + ": " +
                (lloguer.precio_de_Vehiculo() * EUROS_PER_UNITAT_DE_COST) + "€" + "\n";
        }

        // afegeix informació final
        resultat += "Import a pagar: " + importTotal() + "€\n" +
            "Punts guanyats: " + bonificacionsTotals() + "\n";
        System.out.println("XXX informe retorna " + resultat);
        return resultat;
    
        		 
    }
    //HTML ejercicio 21
    public String informeHtml() {
    	String resultat = "<h1>Informe de lloguers</h1>" +
                "<p>Informe de lloguers del client <em>"+getNom() +"</em>"+
                " (<strong>" + getNif() + "</strong>)</p>";
    			resultat += "<table><tr><td>"
        		+ "<strong>Marca</strong></td><td><strong>Model</strong>"
        		+ "</td><td><strong>Import</strong></td></tr>";
            for (Lloguer lloguer: lloguers) {
            	
                resultat += 
                	
                    "<tr><td>"+lloguer.getVehicle().getMarca()+"</td>" +
                    "<td>"+
                    lloguer.getVehicle().getModel()+"</td>" + "<td>" +
                    (lloguer.precio_de_Vehiculo() * EUROS_PER_UNITAT_DE_COST) + "€" + "</td></tr>\n";
            }

            // afegeix informació final
            resultat += "</table><p>Import a pagar: <em>" + importTotal() + "€</em></p>\n" +
                "<p>Punts guanyats:<em>" + bonificacionsTotals() + "</em></p>\n";
            System.out.println("XXX informe retorna " + resultat);
            File f= new File("test.html");
            try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.write(resultat);
				bw.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
            return resultat;
    }
    
    //Ejercicio16 creamos la funcion importTotal
    public double importTotal() {
    	double total=0;
    	for(Lloguer lloguer: lloguers) {
    		total+= lloguer.precio_de_Vehiculo()*EUROS_PER_UNITAT_DE_COST;
    	}
    	return total;
    }
    //Ejercicio 17 crear funcico bonificacionsTotals()
    public int bonificacionsTotals() {
		int bonificacions = 0;
		for(Lloguer lloguer: lloguers) {
			bonificacions += lloguer.bonificaciondelloguer();
		}

		return bonificacions;
	}
   
}
