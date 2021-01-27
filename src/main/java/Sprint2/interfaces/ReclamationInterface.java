package Sprint2.interfaces;

import java.util.List;
import java.util.Set;

import Sprint2.entities.Gerant;
import Sprint2.entities.Reclamation;;

public interface ReclamationInterface {
	 List<Reclamation> retrieveAllReclamations();
	 Reclamation addReclamation(Reclamation r);
	 void deleteReclamation(int id);
	 Reclamation updateReclamation(Reclamation r);
	 Reclamation retrieveReclamation(int id);
	 Set<Reclamation> getGerantReclams(int id);
	 Set<Reclamation> getCommandeReclams(int id);	 
}
