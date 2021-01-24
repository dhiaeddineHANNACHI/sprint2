package Sprint2.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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


    public Membre(String nom, String prenom,String username, String password, String email, String adresse, String role, int numinscrit) {
        super(nom, prenom, username,password, email, adresse, role);
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
