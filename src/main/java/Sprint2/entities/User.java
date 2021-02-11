package Sprint2.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") 
		})

public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	@NotNull
	@Size(min = 3, max = 20)
	private String nom;

	@Column
	@NotNull
	@Size(min = 3, max = 20)
	private String prenom;

	@Column
	@NotNull
	@Size(min = 5, max = 20)
	private String username;

	@Column
	@NotNull
	@Size(min = 1, max = 20)
	private String email;
	
	@Column
	@NotNull
	@Size(min = 5, max = 10)
	private String password;

	@Column
	@NotNull
	@Size(min = 1, max = 20)
	private String adresse;
	@JsonIgnoreProperties("affectedTo")
    @OneToMany(mappedBy = "affectedTo")
    private Set<Reclamation> reclams = new HashSet<Reclamation>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "membre",fetch = FetchType.LAZY)
    private Set<Feedback> feedbacks = new HashSet<Feedback>();

	public User() {
	}

	public User(String nom, String prenom, String username, String email, String password, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.adresse = adresse;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Set<Reclamation> getReclams() {
		return reclams;
	}

	public void addReclam(Reclamation reclam) {
		this.reclams.add(reclam);
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", username=" + username + ", email=" + email
				+ ", adresse=" + adresse + ", password=" + password + ", roles=" + roles + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}

