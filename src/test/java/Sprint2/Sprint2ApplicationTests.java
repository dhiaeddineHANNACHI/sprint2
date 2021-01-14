package Sprint2;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Sprint2.entities.Facture;
import Sprint2.services.FactureServiceImpl;

@SpringBootTest
class Sprint2ApplicationTests {

	
	@Autowired
	FactureServiceImpl factureService ;
	
	
	@Test
	void contextLoads() 
	{	
  //	factureService.getFacture(1);
	     factureService.afficherFactures();
	}

	
	
	
	
}
