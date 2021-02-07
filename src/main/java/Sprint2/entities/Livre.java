package Sprint2.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Livre implements Serializable {
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int livre_id;
	@Column
	@NotNull
	@Size(min = 1, max = 20)
	private String titre_livre;
	@Column
	@NotNull
	@Size(min = 1, max = 10)
	private String langue;
	@Column
	@NotNull
	@Size(min = 1, max = 50)
	private String description;
	@Column
	@NotNull
	private int nb_pages;
	@Column
	@NotNull
	private int nb_exemplaires;
	@Column
	@NotNull
	private String annee;
	@Column
	@NotNull
	private Double prix;
	@Column
	@NotNull
	private String image;

	@JsonIgnoreProperties("livres")
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "edition_id", nullable = false)
	private Edition edition;

	@JsonIgnoreProperties("livres")
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "livre_auteur",
			joinColumns = @JoinColumn(name = "livre_id"),
			inverseJoinColumns = @JoinColumn(name = "auteur_id"))
	private Set<Auteur> auteurs;

	public void setLivre_id(int livre_id) {
		this.livre_id = livre_id;
	}

	public void setAuteurs(Set<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "livre_genre",
			joinColumns = @JoinColumn(name = "livre_id"),
			inverseJoinColumns = @JoinColumn(name = "id_genre"))
	private Set<Genre> genres;

	@JsonIgnoreProperties("livres")
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "livre_feedback",
			joinColumns = @JoinColumn(name = "livre_id"),
			inverseJoinColumns = @JoinColumn(name = "id_fb"))
	private Set<Feedback> feedbacks;

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "ligne_Commandes",
			joinColumns =  @JoinColumn(name = "livre_id"),
			inverseJoinColumns = @JoinColumn(name = "id_com"))
	List<Commande> commandes;


	public Livre(String titre_livre, String langue, String description, int nb_pages, int nb_exemplaires, String annee,
				 Double prix, String image) {
		this.titre_livre = titre_livre;
		this.langue = langue;
		this.description = description;
		this.nb_pages = nb_pages;
		this.nb_exemplaires = nb_exemplaires;
		this.annee = annee;
		this.prix = prix;
		this.image = image;

	}

	public String getTitre_livre() {
		return titre_livre;
	}

	public void setTitre_livre(String titre_livre) {
		this.titre_livre = titre_livre;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNb_pages() {
		return nb_pages;
	}

	public void setNb_pages(int nb_pages) {
		this.nb_pages = nb_pages;
	}

	public int getNb_exemplaires() {
		return nb_exemplaires;
	}

	public void setNb_exemplaires(int nb_exemplaires) {
		this.nb_exemplaires = nb_exemplaires;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}

	public Set<Auteur> getAuteurs() {
		return auteurs;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public Set<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public int getLivre_id() {
		return livre_id;
	}



	@Override
	public String toString() {
		return "Livre [livre_id=" + livre_id + ", titre_livre=" + titre_livre + ", langue=" + langue + ", description="
				+ description + ", nb_pages=" + nb_pages + ", nb_exemplaires=" + nb_exemplaires + ", annee=" + annee
				+ ", prix=" + prix + ", image=" + image + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + livre_id;
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
		Livre other = (Livre) obj;
		if (livre_id != other.livre_id)
			return false;
		return true;
	}

}