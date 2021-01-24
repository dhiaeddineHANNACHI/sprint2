package Sprint2.Services;

import java.util.List;

import Sprint2.Repository.StatLivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Sprint2.entities.Livre;

@Service
public class StatistiqueLivreServiceImpl implements IStatistiqueLivreService {
	@Autowired
private StatLivreRepository statlivrerepo;


	@Override
	public List<Livre> listeLivre() {

		return (List<Livre>) statlivrerepo.findAll();
	}

	@Override
	public List<Livre> listeLivreParId(int livre_id) {
		return (List<Livre>) statlivrerepo.findById(livre_id);
	}


	@Override
	public long NbrLivre() {
		return (long) statlivrerepo.count();
	}

	@Override
	public long NbrLivreParEdition(int id_editeur) {
		return (long) statlivrerepo.CountBookByEdition(id_editeur) ;
	}

	@Override
	public List<Livre> ListBookByGender(String nom_genre) {
		return (List<Livre>) statlivrerepo.ListBookByGender(nom_genre);
	}

	@Override
	public long CountBookByGender(String nom_genre) {
		return statlivrerepo.CountBookByGender(nom_genre);
	}


}
