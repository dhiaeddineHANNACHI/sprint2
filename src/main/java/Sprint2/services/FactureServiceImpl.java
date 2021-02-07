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
	public Map<String, Boolean> AjouterFacture(Facture f){
		Map<String, Boolean> response = new HashMap<>();
		factureRepository.save(f);
       response.put("AjouterFacture", Boolean.TRUE);
        return  response;
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
	public Map<String, Boolean> UpdateFacture(Facture f) {
		Map<String, Boolean> response = new HashMap<>();
		response.put("UpdateFacture", Boolean.TRUE);
		factureRepository.save(f);
		return  response;
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
