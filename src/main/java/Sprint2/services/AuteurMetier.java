package Sprint2.services;


import java.util.List;
import java.util.Set;

import Sprint2.entities.Auteur;
import Sprint2.entities.Livre;

public interface AuteurMetier {

	public Auteur addAuteur(Auteur a);
	public List<Auteur> listeAuteurs();
	public boolean deleteAuteur(int id);
	public Auteur updateAuteur(Auteur a);
	public Auteur getAuteurById(int id);
	public Long nbAuteurs();
	
}
