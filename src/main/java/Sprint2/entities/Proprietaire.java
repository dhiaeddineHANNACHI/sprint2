package Sprint2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE)
public class Proprietaire extends User{
	@Column
	@NotNull
	@Size(min = 1, max = 15)
	private String immatriculation;

    public Proprietaire() {
        super();
    }

  

    public Proprietaire(String nom, String prenom, String username,String password, String email, String adresse,String immatriculation) {
        super(nom,  prenom,  username,  email,  password,  adresse);
        this.immatriculation = immatriculation;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String toString() {
        String res = super.toString() + " immatriculation :" + this.immatriculation;
        return res;
    }
}
