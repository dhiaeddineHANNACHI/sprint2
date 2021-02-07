package Sprint2.services;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sprint2.entities.Edition;
import Sprint2.entities.Livre;
import Sprint2.repositories.EditionRepository;

@Service
public class EditionMetierImpl implements EditionMetier{

	@Autowired
	EditionRepository editionRepository;
	
	@Override
	public Edition addEdition(Edition e) {
		return editionRepository.save(e);
	}

	@Override
	public List<Edition> listeEditions() {
		return (List<Edition>) editionRepository.findAll();
	}

	@Override
	public boolean deleteEdition(int id) {
		editionRepository.deleteById(id);
		return true;
	}

	@Override
	public Edition updateEdition(Edition e) {
		return editionRepository.save(e);
	}

	@Override
	public Edition getEditionById(int id) {
		return editionRepository.getEditionById(id);
	}

	@Override
	public Long nbEditions() {
		return editionRepository.count();
	}

	
}
