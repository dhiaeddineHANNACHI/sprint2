package Sprint2.entities;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Genre implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_genre;
	@Column
	@NotNull
	@Size(min = 1, max = 13)
    private String nom_genre;
	
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "livre_genre",
        joinColumns =  @JoinColumn(name = "id_genre"),
        inverseJoinColumns = @JoinColumn(name = "livre_id")
        )
    private Set < Livre > livres;
    
	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Genre(@NotNull @Size(min = 1, max = 13) String nom_genre) {
		super();
		this.nom_genre = nom_genre;
		
	}
	public String getNom_genre() {
		return nom_genre;
	}
	public void setNom_genre(String nom_genre) {
		this.nom_genre = nom_genre;
	}
	
	public void setId_genre(int id_genre) {
		this.id_genre = id_genre;
	}
	public int getId_genre() {
		return id_genre;
	}
	
	public Set<Livre> getLivres() {
		return livres;
	}
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	@Override
	public String toString() {
		return "Genre [id_genre=" + id_genre + ", nom_genre=" + nom_genre + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_genre;
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
		Genre other = (Genre) obj;
		if (id_genre != other.id_genre)
			return false;
		return true;
	}

    

}
