package Sprint2.interfaces;

import java.util.List;

import Sprint2.entities.Reclamation;;

public interface ReclamationInterface {
	 List<Reclamation> retrieveAllReclamations();
	 Reclamation addReclamation(Reclamation n);
	 void deleteReclamation(int id);
	 Reclamation updateReclamation(Reclamation n);
	 Reclamation retrieveReclamation(int id);
}
