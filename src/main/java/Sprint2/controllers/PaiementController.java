package Sprint2.controllers;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;

import Sprint2.entities.PaiementC;
import Sprint2.utils.Paiement;
@RestController
public class PaiementController {
 
    @PostMapping(value = "/paiment",consumes =MediaType.APPLICATION_JSON_VALUE
)
    private void  makePaiement(@RequestBody  PaiementC pc)  {
        Paiement.PaiementStripe(pc);
    }
 
		
		
	}
	

