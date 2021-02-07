package Sprint2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    public Gerant() {
        super();
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

	@Override
	public String toString() {
		return  (super.toString() + "rib=" + rib + ", matricule=" + matricule + ", salaire=" + salaire + "]");
	}

}
