package Sprint2.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Edition implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_editeur;
	@Column
	@NotNull 
	@Size(min = 1, max = 15)
    private String pays;
	@Column
	@NotNull 
	@Size(min = 1, max = 20)
    private String adresse;
	@Column 
    private double longitude;
	@Column
    private double latitude;
    
    @OneToMany(mappedBy = "edition",fetch=FetchType.LAZY)
    private List<Livre> livres;

	public Edition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Edition(@NotNull @Size(min = 1, max = 15) String pays, @NotNull @Size(min = 1, max = 20) String adresse,
			double longitude, double latitude) {
		super();
		this.pays = pays;
		this.adresse = adresse;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public int getId_editeur() {
		return id_editeur;
	}

	public void setId_editeur(int id_editeur) {
		this.id_editeur = id_editeur;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	public String getAdresse() {
		return adresse;
	}

	@Override
	public String toString() {
		return "Edition [id_editeur=" + id_editeur + ", pays=" + pays + ", adresse=" + adresse + ", longitude="
				+ longitude + ", latitude=" + latitude + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_editeur;
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
		Edition other = (Edition) obj;
		if (id_editeur != other.id_editeur)
			return false;
		return true;
	}

   
}
