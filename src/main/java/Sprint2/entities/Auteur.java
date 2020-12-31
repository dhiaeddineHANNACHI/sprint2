package Sprint2.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Auteur {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int auteur_id;
	@Column
	@NotNull
	@Size(min = 1, max = 20)
    private String nom ;
	@Column
	@NotNull
	@Size(min = 1, max = 20)
    private String prenom;
	@Column
	@NotNull
	@Size(min = 1, max = 50)
    private String bio ;
	@Column
	@NotNull 
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date date_naissance;
	
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "livre_auteur",
        joinColumns =  @JoinColumn(name = "auteur_id"),
        inverseJoinColumns = @JoinColumn(name = "livre_id")
        )
    private Set < Livre > livres = new HashSet < > ();

    public Auteur() {
    }

	public Auteur(@NotNull @Size(min = 1, max = 20) String nom, @NotNull @Size(min = 1, max = 20) String prenom,
			@NotNull @Size(min = 1, max = 50) String bio, @NotNull Date date_naissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.bio = bio;
		this.date_naissance = date_naissance;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	public void setAuteur_id(int auteur_id) {
		this.auteur_id = auteur_id;
	}

	@Override
	public String toString() {
		return "Auteur [auteur_id=" + auteur_id + ", nom=" + nom + ", prenom=" + prenom + ", bio=" + bio
				+ ", date_naissance=" + date_naissance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + auteur_id;
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
		Auteur other = (Auteur) obj;
		if (auteur_id != other.auteur_id)
			return false;
		return true;
	}





    

}
