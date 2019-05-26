import java.util.Iterator;
import java.util.Vector;

public class Client {
    private String nif;
    private String nom;
    private String telefon;
    private static Vector<Lloguer> lloguers;
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
        int bonificacions = 0;
        String resultat = "Informe de lloguers del client " +
            getNom() +
            " (" + getNif() + ")\n";
        for (Lloguer lloguer: lloguers) {
        	
            // afegeix lloguers freqüents
        	//ya no lo necesitamos ya que tenemos una funcion que lo hace
            //bonificacions ++;
        	//bonificaciondelloguer(lloguer);
        	bonificacions+= lloguer.bonificaciondelloguer();

            // afegeix bonificació per dos dies de lloguer de Luxe
            if (lloguer.getVehicle().getCategoria() == Vehicle.Alt &&
                    lloguer.getDies()>1 ) {
                bonificacions ++;
            }

            // composa els resultats d'aquest lloguer
            resultat += "\t" +
                lloguer.getVehicle().getMarca() +
                " " +
                lloguer.getVehicle().getModel() + ": " +
                (lloguer.quantitat() * 30) + "€" + "\n";
        }

        // afegeix informació final
        resultat += "Import a pagar: " + importTotal() + "€\n" +
            "Punts guanyats: " + bonificacions + "\n";
        System.out.println("XXX informe retorna " + resultat);
        return resultat;
    
        		 
    }
    //Ejercicio 13 ya no lo necesitamos
    //Bonificacion de venta
    /*public int bonificaciondelloguer(Lloguer lloguer) {
    	//creamos la variable de 0 y contador que sume
		int bonificacions = 0;
		bonificacions++;
		//comprobamos si la categoria del vehicle es alto  y si sus dias son superior a un dia
		if (lloguer.getVehicle().getCategoria() == Vehicle.Alt && lloguer.getDies() > 1) {
			bonificacions++;
		}
		return bonificacions;
	}*/
    
    //Ejercicio16 creamos la funcion importTotal
    public double importTotal() {
    	double total=0;
    	for(Lloguer lloguer: lloguers) {
    		total+= lloguer.quantitat()*30;
    	}
    	return total;
    }
   


    //Mostramos los datos de la venta
    public String mostrarDatos() {
		String infor = null;
		for (Lloguer lloguer: lloguers) {
			infor = "Client:" +getNom()+"\n"+
					getNif()+"\n"+
					getTelefon()+"\n"+
					"1. Vehicle: "+"\n"+lloguer.getVehicle().getMarca();
		}
		return infor;
	}
    
}
