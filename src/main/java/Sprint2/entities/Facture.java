package Sprint2.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Facture implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_fact;
	@Column
	@NotNull 
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date date_fact;
	@Column
	@NotNull 
    private float montant;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_com")
    private Commande commande;

	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facture(@NotNull Date date_fact, @NotNull float montant) {
		super();
		this.date_fact = date_fact;
		this.montant = montant;
	}

	public Date getDate_fact() {
		return date_fact;
	}

	public void setDate_fact(Date date_fact) {
		this.date_fact = date_fact;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public int getId_fact() {
		return id_fact;
	}

	@Override
	public String toString() {
		return "Facture [id_fact=" + id_fact + ", date_fact=" + date_fact + ", montant=" + montant + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_fact == null) ? 0 : date_fact.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facture other = (Facture) obj;
		if (date_fact == null) {
			if (other.date_fact != null)
				return false;
		} else if (!date_fact.equals(other.date_fact))
			return false;
		return true;
	}
	

	
	

    
}
