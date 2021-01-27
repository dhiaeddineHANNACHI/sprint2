package Sprint2.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE)
public class Gerant extends User{
	
	@Column
	@NotNull
	@Size(min = 20, max = 20)
	private String rib;
	@Column
	@NotNull
	@Size(min = 1, max = 10)
    private String matricule;
	@Column
	@NotNull
    private double salaire;
	
	   
    @OneToMany(mappedBy = "affectedTo")
    private Set<Reclamation> reclams = new HashSet<Reclamation>();

    public Gerant() {
        super();
    }

    public Gerant(int id, String nom, String prenom, String username, String password, String email,
                  String adresse, String role, String rib,double salaire, String matricule) {
        super(id, nom, prenom, username, password, email, adresse, role);
        this.rib=rib;
        this.matricule=matricule;
        this.salaire=salaire;
    }
    public Gerant(String nom, String prenom, String username, String password, String email,
            String adresse, String role, String rib,double salaire, String matricule) {
        super(nom, prenom, username, password, email, adresse, role);
        this.rib=rib;
        this.matricule=matricule;
        this.salaire=salaire;
    }

    

    /**
	 * @return the rib
	 */
	public String getRib() {
		return rib;
	}

	/**
	 * @param rib the rib to set
	 */
	public void setRib(String rib) {
		this.rib = rib;
	}

	public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

	public Set<Reclamation> getReclams() {
		return reclams;
	}

	public void setReclams(Set<Reclamation> reclams) {
		this.reclams = reclams;
	}

	@Override
	public String toString() {
		return  (super.toString() + "rib=" + rib + ", matricule=" + matricule + ", salaire=" + salaire + "]");
	}

}
