package Sprint2.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Feedback implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_fb;
	@Column
	@NotNull
    private int nb_etoile;
	@Column
	@NotNull
	@Size(min = 1, max = 50)
    private String commentaire;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "edition_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Membre membre;
	
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "livre_feedback",
        joinColumns =  @JoinColumn(name = "id_fb"),
        inverseJoinColumns = @JoinColumn(name = "livre_id")
        )
    private Set < Livre > livres = new HashSet < > ();



    public Feedback() {
    }

	public Feedback(@NotNull int nb_etoile, @NotNull @Size(min = 1, max = 50) String commentaire) {
		super();
		this.nb_etoile = nb_etoile;
		this.commentaire = commentaire;
	}

	public int getId_fb() {
		return id_fb;
	}

	public void setId_fb(int id_fb) {
		this.id_fb = id_fb;
	}

	public int getNb_etoile() {
		return nb_etoile;
	}

	public void setNb_etoile(int nb_etoile) {
		this.nb_etoile = nb_etoile;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	public String getCommentaire() {
		return commentaire;
	}

	@Override
	public String toString() {
		return "Feedback [id_fb=" + id_fb + ", nb_etoile=" + nb_etoile + ", commentaire=" + commentaire + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_fb;
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
		Feedback other = (Feedback) obj;
		if (id_fb != other.id_fb)
			return false;
		return true;
	}

   
}
