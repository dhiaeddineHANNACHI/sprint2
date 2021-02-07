package Sprint2.controllers;

import Sprint2.entities.Livre;
import Sprint2.services.StatistiqueLivreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.util.List;


@RestController
public class StatLivreController {
	
	@Autowired
	private StatistiqueLivreServiceImpl sls;
	
	@GetMapping("/listeLivre")
	public List<Livre> getAllbook()
	{

		return  (List<Livre>) sls.listeLivre();
	}
	@GetMapping(value="/listeLivreParId/{livre_id}")
	public List<Livre> getAllbookById(@PathVariable int livre_id)
	{
		return  (List<Livre>) sls.listeLivreParId(livre_id);
	}
	@GetMapping("/nbrlivre")
	public Long Nbrbook()
	{
		return  (Long) sls.NbrLivre();
	}
	@GetMapping("/nbrlivreParEdition/{id_editeur}")
	public Long NbrbookParEditeur(@PathVariable int id_editeur)
	{
		return  (Long) sls.NbrLivreParEdition(id_editeur);
	}
	@GetMapping("/ListelivreParGenre/{nom_genre}")
	public List<Livre> ListbookParEditeur(@PathVariable String nom_genre)
	{
		return (List<Livre>) sls.ListBookByGender(nom_genre) ;
	}
	@GetMapping("/nbrlivreParGenre/{nom_genre}")
	public Long NbrbookParGenre(@PathVariable String nom_genre)
	{
		return  (Long) sls.CountBookByGender(nom_genre);
	}

}
