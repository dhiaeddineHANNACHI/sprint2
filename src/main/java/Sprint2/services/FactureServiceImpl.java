package Sprint2.services;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sprint2.entities.Facture;
import Sprint2.repository.FactureRepository;

@Service
public class FactureServiceImpl implements IFactureService
{
	private static final Logger logger = Logger.getLogger(FactureServiceImpl.class);
	
	@Autowired
	FactureRepository factureRepository;

	@Override
	public void AjouterFacture(Facture f){
      factureRepository.save(f);		
	}

	@Override
	public Map<String, Boolean> deleteById(int id)
	{
		Map<String, Boolean> response = new HashMap<>();
		factureRepository.deleteById(id);
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@Override
	public void UpdateFacture(Facture f) {
		factureRepository.save(f);
	}
	@Override
	public List<Facture> afficherFactures() {		
		logger.info(factureRepository.findAll().isEmpty()+"liste est");
		return factureRepository.findAll(); 
	}
	@Override
	public Facture getFacture(int id) 
	{
		return  factureRepository.findById(id);	
	}
}
