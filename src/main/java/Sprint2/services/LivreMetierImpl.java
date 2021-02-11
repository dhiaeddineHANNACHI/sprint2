package Sprint2.services;


import java.util.List;
import java.util.Set;

import Sprint2.interfaces.LivreMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sprint2.entities.Auteur;
import Sprint2.entities.Edition;
import Sprint2.entities.Genre;
import Sprint2.entities.Livre;
import Sprint2.repositories.LivreRepository;

@Service
public class LivreMetierImpl implements LivreMetier {
	@Autowired
	LivreRepository livreRepository;

	@Override
	public List<Livre> listeLivres() {
		return (List<Livre>) livreRepository.findAll();
	}

	@Override
	public boolean deleteLivre(int id) {
		livreRepository.deleteById(id);
		return true;

	}

	@Override
	public Livre updateLivre(Livre l) {
		return livreRepository.save(l);
	}

	@Override
	public Livre getLivreById(int id) {
		return livreRepository.getLivreById(id);
	}

	@Override
	public Set<Genre> getGenresByLivre(int id_livre) {
		return livreRepository.getLivreById(id_livre).getGenres();
	}

	@Override
	public Set<Auteur> getAuteursByLivre(int livre_id) {
		return livreRepository.getLivreById(livre_id).getAuteurs();
	}

	@Override
	public Edition getEditionsByLivre(int livre_id) {
		return livreRepository.getLivreById(livre_id).getEdition();
	}

	@Override
	public Livre addLivre(Livre l) {

		return livreRepository.save(l);

	}

	@Override
	public int nbLivres() {
		return livreRepository.NbLivres();
	}

}
