import java.util.Vector;

public class Client {
	private String nif;
	private String nom;
	private String telefon;
	private Vector<Lloguer> Lloguer;
	
	//Lamar a las funciones 
	//Constructores
	public Client(String nif,String nom,String telefon) {
		this.nif=nif;
		this.nom=nom;
		this.telefon=telefon;
		this.Lloguer=new Vector<Lloguer>();
		
	}

	//Los get y set 
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public Vector<Lloguer> getLloguer() {
		return Lloguer;
	}

	public void setLloguer(Vector<Lloguer> lloguer) {
		Lloguer = lloguer;
	}

	//---------------------------------------
	public void afegeix() {
		
	}
	
	public void eliminar() {
		
	}
	public void conte() {
		
	}
	
	public void inform() {
		
	}
	
	
	
}
