package Sprint2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import Sprint2.entities.Reclamation;
import Sprint2.interfaces.ReclamationInterface;
import Sprint2.repositories.ReclamationRepository;;

public class ReclamationService implements ReclamationInterface {

	@Autowired
	ReclamationRepository recRepo; 
	
	@Override
	public List<Reclamation> retrieveAllReclamations() {
		return (List<Reclamation>) recRepo.findAll();
	}

	@Override
	public Reclamation addReclamation(Reclamation r) {
		return recRepo.save(r);
	}

	@Override
	public void deleteReclamation(int id) {
		recRepo.removeReclamationById(id);
		
	}

	@Override
	public Reclamation updateReclamation(Reclamation n) {

		return recRepo.save(n);
	}

	@Override
	public Reclamation retrieveReclamation(int id) {

		return recRepo.getReclamationById(id);
	}

}
