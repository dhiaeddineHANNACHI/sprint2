
package Sprint2;

import java.lang.reflect.Member;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Sprint2.entities.Commande;
import Sprint2.entities.Facture;
import Sprint2.entities.Membre;
import Sprint2.repository.FactureRepository;
import javassist.expr.NewArray;

@SpringBootApplication
public class Sprint2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sprint2Application.class, args);
	}

	
}