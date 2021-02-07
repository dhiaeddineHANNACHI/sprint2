package Sprint2.services;


import java.util.List;
import java.util.Set;

import Sprint2.entities.Auteur;
import Sprint2.entities.Edition;
import Sprint2.entities.Genre;
import Sprint2.entities.Livre;



public interface LivreMetier {
	
	public Livre addLivre(Livre l);
	public List<Livre> listeLivres();
	public boolean deleteLivre(int id);
	public Livre updateLivre(Livre l);
	public Livre getLivreById(int id);
	public Set<Genre> getGenresByLivre(int id_livre);
	public Set<Auteur> getAuteursByLivre(int livre_id);
	public Edition getEditionsByLivre(int livre_id);
	public int nbLivres();
	

}
