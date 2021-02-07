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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Facture implements Serializable
{
	@Id 
	@GeneratedValue
	private int id;

	@NotNull 
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date date_fact;
	@NotNull
    private float montant;



	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("facture")
    private Commande commande;





	public void setId(int id_fact) {
		this.id = id_fact;
	}
	public Facture()
	{
		super();
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

	public int getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_fact == null) ? 0 : date_fact.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
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
	
	public Facture(int id, @NotNull Date date_fact, @NotNull float montant) {
		super();
		this.id = id;
		this.date_fact = date_fact;
		this.montant = montant;
	}
	public Facture(int id, @NotNull Date date_fact, @NotNull float montant, Commande commande) {
		super();
		this.id = id;
		this.date_fact = date_fact; 
		this.montant = montant;
		this.commande = commande;
	}

	@Override
	public String toString() 
	{
		return "Facture [id_fact=" + id + ", date_fact=" + date_fact + ", montant=" + montant +"]";
	}

	
}
