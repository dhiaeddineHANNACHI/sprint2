package Sprint2.entities;


import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Reclamation {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int reclam_id;
	@Column
	@NotNull
	@Size(min = 1, max = 20)
    private String type ;
	@Column
	@NotNull
    private String message;
	@Column
	@NotNull
	@Size(min = 1, max = 50)
    private String etat ;
	@Column
	@NotNull 
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date date_reclamation;
	@Column
    private String filePath;
    @ManyToOne
    @JoinColumn(name ="affectedTo",referencedColumnName ="id",insertable = false,updatable = false)
	private Gerant affectedTo;
    @ManyToOne
    @JoinColumn(name ="id",referencedColumnName ="id",insertable = false,updatable = false)
    private Commande commande;
    
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((date_reclamation == null) ? 0 : date_reclamation.hashCode());
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + reclam_id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Reclamation other = (Reclamation) obj;
		if (reclam_id != other.reclam_id)
			return false;
		
		return true;
	}

	public Reclamation() {

	}
	
	public Reclamation(@NotNull @Size(min = 1, max = 20) String type, @NotNull String message,
			@NotNull @Size(min = 1, max = 50) String etat, @NotNull Date date_reclamation, String filePath,
			Gerant affectedTo, Commande command) {
		super();
		this.type = type;
		this.message = message;
		this.etat = etat;
		this.date_reclamation = date_reclamation;
		this.filePath = filePath;
		this.affectedTo = affectedTo;
		this.commande = command;
	}

	
	
	public int getReclam_id() {
		return reclam_id;
	}
	public void setReclam_id(int reclam_id) {
		this.reclam_id = reclam_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Date getDate_reclamation() {
		return date_reclamation;
	}
	public void setDate_reclamation(Date date_reclamation) {
		this.date_reclamation = date_reclamation;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Gerant getAffectedTo() {
		return affectedTo;
	}

	public void setAffectedTo(Gerant affectedTo) {
		this.affectedTo = affectedTo;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}
