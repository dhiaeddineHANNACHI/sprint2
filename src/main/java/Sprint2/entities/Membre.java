package Sprint2.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE)
public class Membre extends User{
	@Column
	@NotNull
	private int numinscrit;


    @OneToMany(mappedBy = "membre",fetch = FetchType.LAZY)
    private Set<Feedback> feedbacks = new HashSet<Feedback>();

	@OneToMany(mappedBy = "membre",fetch = FetchType.LAZY)
    private Set<Commande> commandes = new HashSet<Commande>();
   

    public Membre() {
        super();
    }


    public Membre(String nom, String prenom, String username, String password, String email, String adresse, int numinscrit) {
        super(nom,  prenom,  username,  email,  password,  adresse);
        this.numinscrit = numinscrit;
    }

    public int getNuminscrit() {
        return numinscrit;
    }

    public void setNuminscrit(int numinscrit) {
        this.numinscrit = numinscrit;
    }


	@Override
	public String toString() {
		return "Membre [numinscrit=" + numinscrit + ", feedbacks=" + feedbacks + ", commandes=" + commandes + "]";
	}    
}
