package Sprint2.Services;

import java.util.List;

import Sprint2.entities.Livre;

public interface IStatistiqueLivreService {


	List<Livre> listeLivre();
	List<Livre> listeLivreParId(int livre_id);
	long NbrLivre();
	long NbrLivreParEdition(int id_editeur);
	List<Livre> ListBookByGender(String nom_genre);
	long CountBookByGender(String nom_genre);





}
