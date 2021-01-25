package Sprint2;

import Sprint2.entities.Commande;
import Sprint2.entities.Membre;
import Sprint2.services.CommandeServcieImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Sprint2.entities.Facture;
import Sprint2.services.FactureServiceImpl;

import java.util.Date;

@SpringBootTest
class Sprint2ApplicationTests {

	
	@Autowired
	FactureServiceImpl factureService ;


	@Autowired
	CommandeServcieImpl commandeServcie;

	
	@Test
	void contextLoads() 
	{
	}

	
	
	
	
}
