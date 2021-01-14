package Sprint2.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class LigneCommande implements Serializable{
	
	@EmbeddedId
    private LivreCommandePK id;
		

	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	@JsonIgnoreProperties("ligneCommandes")
	@ManyToOne
	@JoinColumn(name ="livre_id",referencedColumnName ="livre_id",insertable = false,updatable = false)
	private Livre livre;


	public Livre getLivre() {
		return livre;
	}

	@JsonIgnoreProperties("ligneCommandes")
	@ManyToOne
	@JoinColumn(name ="id_com",insertable = false,updatable = false)
    private Commande commande;




	public Commande getCommande() {
		return commande;
	}


    private int nbrArticle;

    private float total ;

	public LivreCommandePK getId() {
		return id;
	}

	public void setId(LivreCommandePK id) {
		this.id = id;
	}


	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public int getNbrArticle() {
		return nbrArticle;
	}

	public void setNbrArticle(int nbrArticle) {
		this.nbrArticle = nbrArticle;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public LigneCommande(LivreCommandePK id, int nbrArticle, float total) {
		super();
		this.id = id;
		this.nbrArticle = nbrArticle;
		this.total = total;
	}

	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", livre=" + livre + ", commande=" + commande + ", nbrArticle=" + nbrArticle
				+ ", total=" + total + "]";
	}
}
