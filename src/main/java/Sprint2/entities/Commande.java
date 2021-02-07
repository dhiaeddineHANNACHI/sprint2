package Sprint2.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Commande  implements Serializable
{
	@Id @GeneratedValue
    private int id;
	@Column
	@NotNull 
	@JsonFormat(pattern="yyyy-MM-dd")
	@JsonIgnore
    private Date date_com;
	@Column
    private int livraison=0;
	public Commande() {
		super();
	}
	@ManyToOne
	private Membre membre;
	public Commande(@NotNull Date date_com, int livraison) {
		super();
		this.date_com = date_com;
		this.livraison = livraison;
	}
	@OneToOne(mappedBy = "commande",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private Facture facture;
	public void setDate_com(Date date_com)
	{
		this.date_com = date_com;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id_com) {
		this.id = id_com;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_com == null) ? 0 : date_com.hashCode());
		return result;
	}
	public List<Livre> getLivres() {
		return livres;
	}
	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name ="ligne_Commandes",
			joinColumns =  @JoinColumn(name = "id_com"),
			inverseJoinColumns = @JoinColumn(name = "livre_id"))
	List<Livre> livres;
	@Override
	public boolean equals(Object obj)
	{
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
	public Commande(@NotNull Date date_com, int livraison, Membre membre)
	{
		this.date_com = date_com;
		this.livraison = livraison;
		this.membre = membre;
	}
	public Commande(int id, @NotNull Date date_com, int livraison)
	{
		super();
		this.id = id;
		this.date_com = date_com;
		this.livraison = livraison;
	}
	@Override
	public String toString()
	{
		return "Commande [id_com=" + id + ", date_com=" + date_com + ", livraison=" + livraison+"]";
	}
}
