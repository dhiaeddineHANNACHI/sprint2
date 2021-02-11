package Sprint2.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sprint2.entities.Notification;
import Sprint2.entities.Reclamation;
import Sprint2.interfaces.ReclamationInterface;
import Sprint2.repositories.ReclamationRepository;;


@Service
public class ReclamationService implements ReclamationInterface {

	@Autowired
	ReclamationRepository recRepo;
	@Autowired
	NotificationService notifServ;
	
	@Override
	public List<Reclamation> retrieveAllReclamations() {
		return (List<Reclamation>) recRepo.findAll();
	}

	@Override
	public Reclamation addReclamation(Reclamation r) {
		Notification n = new Notification();
		n.setMessage(r.getMessage());
		n.setType("Reclamation !");
		n.setReclam(r);
		notifServ.addNotification(n);
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

	@Override
	public Set<Reclamation> getGerantReclams(int id) {
		// TODO Auto-generated method stub
		return recRepo.getReclamationsByGerant(id);
	}

	@Override
	public Set<Reclamation> getCommandeReclams(int id) {
		// TODO Auto-generated method stub
		return recRepo.getReclamationsByCommande(id);
	}



}
