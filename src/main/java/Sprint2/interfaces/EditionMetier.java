package Sprint2.interfaces;


import java.util.List;
import java.util.Set;

import Sprint2.entities.Edition;
import Sprint2.entities.Livre;

public interface EditionMetier {
	public Edition addEdition(Edition e);
	public List<Edition> listeEditions();
	public boolean deleteEdition(int id);
	public Edition updateEdition(Edition e);
	public Edition getEditionById(int id);
	public Long nbEditions();
	
}
