package Sprint2.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class LigneCommande implements Serializable{
	
	@EmbeddedId
    private LivreCommandePK id;
	
	
	
	@ManyToOne
    @JoinColumn(name ="livre_id",referencedColumnName ="livre_id",insertable = false,updatable = false)
	private Livre livre;
	public Livre getLivre() {
		return livre;
	}

    @ManyToOne
    @JoinColumn(name ="id_com",referencedColumnName ="id_com",insertable = false,updatable = false)
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
    

}
