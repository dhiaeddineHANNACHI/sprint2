package Sprint2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Notification implements Serializable{
	
   @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id_notif;
    @Column
	@NotNull
	@Size(min = 1, max = 10)
   private String type;
    @Column
	@NotNull
	@Size(min = 1, max = 50)
   private String message;
    @Column
   private int vu=0;
    
    @ManyToOne
    @JoinColumn(name ="reclam_id",referencedColumnName ="reclam_id",insertable = false,updatable = false)
    private Reclamation reclam;

   public Notification() {
   }

   public Notification(int id_notif, String type, String message, int vu) {
       this.id_notif = id_notif;
       this.type = type;
       this.message = message;
       this.vu = vu;
   }
   public Notification( String type, String message, int vu) {
       this.type = type;
       this.message = message;
       this.vu = vu;
   }

   public int getId_notif() {
       return id_notif;
   }

   public void setId_notif(int id_notif) {
       this.id_notif = id_notif;
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

   public int getVu() {
       return vu;
   }

   public void setVu(int vu) {
       this.vu = vu;
   }
   

   public Reclamation getReclam() {
	return reclam;
}

public void setReclam(Reclamation reclam) {
	this.reclam = reclam;
}

@Override
   public String toString() {
       return "Notification{" + "id_notif=" + id_notif + ", type=" + type + ", message=" + message + ", vu=" + vu + '}';
   }
   
   
}