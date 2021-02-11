package Sprint2.entities;

public class PaiementC {
	
	private String email;
	private String numcarte ;
	private String datexpmois ;
	private String datexpannee ;
	private String cvc ;
	private String montant;
	
	public PaiementC() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumcarte() {
		return numcarte;
	}
	public void setNumcarte(String numcarte) {
		this.numcarte = numcarte;
	}
	public String getDatexpmois() {
		return datexpmois;
	}
	public void setDatexpmois(String datexpmois) {
		this.datexpmois = datexpmois;
	}
	public String getDatexpannee() {
		return datexpannee;
	}
	public void setDatexpannee(String datexpannee) {
		this.datexpannee = datexpannee;
	}
	public String getCvc() {
		return cvc;
	}
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	public String getMontant() {
		return montant;
	}
	public void setMontant(String montant) {
		this.montant = montant;
	}
}
