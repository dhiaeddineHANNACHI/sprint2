package Sprint2.services;

import java.util.List;

import Sprint2.interfaces.IStatistiqueLivreService;
import Sprint2.repositories.StatLivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Sprint2.entities.Livre;

@Service
public class StatistiqueLivreServiceImpl implements IStatistiqueLivreService {
	@Autowired
private StatLivreRepository statLivreRepository;


	@Override
	public List<Livre> listeLivre() {

		return (List<Livre>) statLivreRepository.findAll();
	}

	@Override
	public List<Livre> listeLivreParId(int livre_id) {
		return (List<Livre>) statLivreRepository.findById(livre_id);
	}


	@Override
	public long NbrLivre() {
		return (long) statLivreRepository.count();
	}

	@Override
	public long NbrLivreParEdition(int id_editeur) {
		return (long) statLivreRepository.CountBookByEdition(id_editeur) ;
	}

	@Override
	public List<Livre> ListBookByGender(String nom_genre) {
		return (List<Livre>) statLivreRepository.ListBookByGender(nom_genre);
	}

	@Override
	public long CountBookByGender(String nom_genre) {
		return statLivreRepository.CountBookByGender(nom_genre);
	}


}
