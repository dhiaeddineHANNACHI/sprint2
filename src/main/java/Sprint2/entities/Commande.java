package Sprint2.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.bind.DefaultValue;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Commande {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_com;
	@Column
	@NotNull 
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date date_com;
	@Column
    private int livraison=0;
    
    
    @OneToMany(mappedBy = "commande")
    private Set<LigneCommande> ligneCommandes = new HashSet<LigneCommande>();
    
    @OneToMany(mappedBy = "commande")
    private Set<Reclamation> reclams = new HashSet<Reclamation>();
    
    public Set<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}
    
    @ManyToOne
    @JoinColumn(name ="id",referencedColumnName ="id",insertable = false,updatable = false)
	private Membre membre;
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande(@NotNull Date date_com, int livraison) {
		super();
		this.date_com = date_com;
		this.livraison = livraison;
	}
	public int getId_com() {
		return id_com;
	}
	public void setId_com(int id_com) {
		this.id_com = id_com;
	}
	public int getLivraison() {
		return livraison;
	}
	public void setLivraison(int livraison) {
		this.livraison = livraison;
	}
	public Membre getMembre() {
		return membre;
	}
	public void setMembre(Membre membre) {
		this.membre = membre;
	}
	public Date getDate_com() {
		return date_com;
	}
	public void setLigneCommandes(Set<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	@Override
	public String toString() {
		return "Commande [id_com=" + id_com + ", date_com=" + date_com + ", livraison=" + livraison + "]";
	}
	
	
	
	public Set<Reclamation> getReclams() {
		return reclams;
	}
	public void setReclams(Set<Reclamation> reclams) {
		this.reclams = reclams;
	}
	public void setDate_com(Date date_com) {
		this.date_com = date_com;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_com == null) ? 0 : date_com.hashCode());
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
		Commande other = (Commande) obj;
		if (date_com == null) {
			if (other.date_com != null)
				return false;
		} else if (!date_com.equals(other.date_com))
			return false;
		return true;
	}
    
}
