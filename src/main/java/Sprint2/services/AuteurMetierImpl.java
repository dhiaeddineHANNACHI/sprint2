package Sprint2.services;


import java.util.List;

import Sprint2.interfaces.AuteurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sprint2.entities.Auteur;
import Sprint2.repositories.AuteurRepository;
@Service
public class AuteurMetierImpl implements AuteurMetier {
	
	
@Autowired
private AuteurRepository auteurRepository;
	@Override
	public Auteur addAuteur(Auteur a) {
		return auteurRepository.save(a);
	}

	

	@Override
	public boolean deleteAuteur(int id) {
		auteurRepository.deleteById(id);
		return true;
	}

	@Override
	public Auteur updateAuteur(Auteur a) {
		return auteurRepository.save(a);
	}

	@Override
	public Auteur getAuteurById(int id) {
		return auteurRepository.getAuteurById(id);
	}

	@Override
	public Long nbAuteurs() {
		return auteurRepository.count();
	}

	@Override
	public List<Auteur> listeAuteurs() {
		
		return (List<Auteur>) auteurRepository.findAll();
	}


}
