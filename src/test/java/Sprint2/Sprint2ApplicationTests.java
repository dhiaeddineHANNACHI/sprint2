package Sprint2;

import Sprint2.services.ServiceStatisticsVenteImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sprint2ApplicationTests {

	@Autowired
	ServiceStatisticsVenteImp serviceStatisticsVente;
	@Test
	void contextLoads() 
	{
		System.out.println(serviceStatisticsVente.getBestSales());
	//	System.out.println(serviceStatisticsVente.getLivreNonVendu());
	//	System.out.println(serviceStatisticsVente.getLivreVendu());
	//	System.out.println(serviceStatisticsVente.getRevenue());
	//	System.out.println(serviceStatisticsVente.getStatCommandeByAuteurLivre());
	//	System.out.println(serviceStatisticsVente.getStatCommandeByGenreLivre());
	}


}
