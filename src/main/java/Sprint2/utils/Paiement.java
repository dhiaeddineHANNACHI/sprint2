package Sprint2.utils;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.BalanceTransaction;
import com.stripe.model.Card;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.CustomerBalanceTransaction;
import com.stripe.model.ExternalAccountCollection;
import com.stripe.model.PaymentSourceCollection;
import com.stripe.model.Token;
import com.stripe.net.RequestOptions;

import Sprint2.entities.PaiementC;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;

import com.stripe.model.PaymentMethod;
public class Paiement {

    public static String ajouterCustomer(String email){
 	   Stripe.apiKey ="sk_test_51HvfmDDN6Y62aNf5QiC0fglaHtLbHTVzqysFohgi68L6RR62Jf6xFpgmPuDUatw9JD6y0f5k2KhzHq52tbywiF4K00BiSHqota";

 Map<String, Object> customerMap = new HashMap<String, Object>();
        customerMap.put("description", "");
        customerMap.put("email", email );


        try {
            Customer customer = Customer.create(customerMap);
            System.out.println(customer.getId());
            return customer.getId();
        } catch (StripeException e) {
            e.printStackTrace();
            
        return "Crash in ajouterMethodeDePaiement";
        }
    }
        public static String ajouterMethodePaiement (String numcarte, String datexpmois, String datexpannee, String cvc) throws StripeException{
      	   Stripe.apiKey ="sk_test_51HvfmDDN6Y62aNf5QiC0fglaHtLbHTVzqysFohgi68L6RR62Jf6xFpgmPuDUatw9JD6y0f5k2KhzHq52tbywiF4K00BiSHqota";

        Map<String, Object> card = new HashMap<>();
card.put("number", numcarte);
card.put("exp_month", datexpmois);
card.put("exp_year", datexpannee);
card.put("cvc", cvc);
Map<String, Object> params = new HashMap<>();
params.put("type", "card");
params.put("card", card);

PaymentMethod paymentMethod =
  PaymentMethod.create(params); 
        
        return paymentMethod.getId();
        } 
        
        public static void attacherCostumerPourMethodePaiement(String customer_id, String id_paiement_method) throws StripeException{
      	   Stripe.apiKey ="sk_test_51HvfmDDN6Y62aNf5QiC0fglaHtLbHTVzqysFohgi68L6RR62Jf6xFpgmPuDUatw9JD6y0f5k2KhzHq52tbywiF4K00BiSHqota";

            PaymentMethod paymentMethod =
  PaymentMethod.retrieve(
    id_paiement_method
  );

Map<String, Object> params = new HashMap<>();
params.put("customer", customer_id);

PaymentMethod updatedPaymentMethod =
  paymentMethod.attach(params);
System.out.println(paymentMethod);

 
    }
        public static void effectuerPaiement(String montant, String devise, String customer_id) throws StripeException{
      	   Stripe.apiKey ="sk_test_51HvfmDDN6Y62aNf5QiC0fglaHtLbHTVzqysFohgi68L6RR62Jf6xFpgmPuDUatw9JD6y0f5k2KhzHq52tbywiF4K00BiSHqota";

            
         Customer customer =
  Customer.retrieve(customer_id);

Map<String, Object> params = new HashMap<>();
params.put("amount", -Integer.parseInt(montant));
params.put("currency", devise);

CustomerBalanceTransaction balanceTransaction =
  customer.balanceTransactions().create(params);
System.out.println(balanceTransaction);
  
        }

        
        public static void PaiementStripe(@RequestBody PaiementC pc) {
        	String customerId="";
        	String paiementId="";
        	 try {
        			
        	customerId=Paiement.ajouterCustomer( pc.getEmail());

        		paiementId=Paiement.ajouterMethodePaiement(pc.getNumcarte(),pc.getDatexpmois(),pc.getDatexpannee(),pc.getCvc());
        		System.out.println(paiementId);
        		System.out.println(pc.getNumcarte());
        		System.out.println(pc.getDatexpmois());
        		System.out.println(pc.getDatexpannee());
        		System.out.println(pc.getCvc());
        		System.out.println(pc.getMontant());

        	  

        	} catch (StripeException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	  try {
				Paiement.attacherCostumerPourMethodePaiement(customerId, paiementId);
			} catch (StripeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      	    try {
				Paiement.effectuerPaiement(pc.getMontant(), "usd", customerId);
			} catch (StripeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
}
