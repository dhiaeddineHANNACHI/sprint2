package Sprint2;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Sprint2.entities.Commande;
import Sprint2.entities.Membre;

@SpringBootApplication
public class Sprint2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sprint2Application.class, args);
	}

	public void run(String... args) throws Exception {
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");

		Membre m1 = new Membre("bgh", "bgh", "medbgh", "jjjjj","medbgh", "aa", "membre", 1234);
		Commande c1 = new Commande(32,formatter1.parse("1998-10-04"),1, m1);
	
	}
}
