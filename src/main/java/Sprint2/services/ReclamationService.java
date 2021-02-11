package Sprint2.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.IOUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import Sprint2.entities.Notification;
import Sprint2.entities.Reclamation;
import Sprint2.entities.User;
import Sprint2.interfaces.ReclamationInterface;
import Sprint2.repositories.NotificationRepository;
import Sprint2.repositories.ReclamationRepository;
import Sprint2.repositories.UserRepository;


@Service
public class ReclamationService implements ReclamationInterface {

	@Autowired
	ReclamationRepository recRepo;
	@Autowired
	NotificationService notifServ;
	@Autowired
	UserRepository urepo;
	@Autowired
	NotificationRepository notifRepo;
	@Override
	public List<Reclamation> retrieveAllReclamations() {
		return (List<Reclamation>) recRepo.findAll();
	}

	@Override
	public Reclamation addReclamation(Reclamation r) {
	    File file = new File(r.getFilePath());
	    FileInputStream input;
		try {
			input = new FileInputStream(file);
		    try {
				MultipartFile multipartFile = new MockMultipartFile("file",
				        file.getName(), "text/plain", IOUtils.toByteArray(input));
			    String fileName = multipartFile.getOriginalFilename();
			    try {
			    	multipartFile.transferTo( new File("C:\\upload\\" + fileName));
			    } catch (Exception e) {
			    	System.out.println(e.getMessage());
			    } 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("file name : -------->"+file.getName());

		recRepo.save(r);
		Notification n = new Notification();
		n.setMessage(r.getMessage());
		n.setType("Reclamation!");
		n.setReclam(r);
		notifServ.addNotification(n);
		notifRepo.save(n);
		System.out.println(n);
        User gerant=getGerantWilthLessReclams();
        System.out.println(gerant);
        gerant.addReclam(r);
        urepo.save(gerant);
        r.setAffectedTo(gerant);
        recRepo.save(r);
		return r;
	}

	@Override
	public void deleteReclamation(int id) {
		recRepo.removeReclamationById(id);
		
	}

	@Override
	public Reclamation updateReclamation(Reclamation n) {
		return recRepo.save(n);
	}

	@Override
	public Reclamation retrieveReclamation(int id) {

		return recRepo.getReclamationById(id);
	}

	@Override
	public Set<Reclamation> getGerantReclams(int id) {
		// TODO Auto-generated method stub
		return recRepo.getReclamationsByGerant(id);
	}

	@Override
	public Set<Reclamation> getCommandeReclams(int id) {
		// TODO Auto-generated method stub
		return recRepo.getReclamationsByCommande(id);
	}
    public User getGerantWilthLessReclams(){
    	User gerant =new User();
		ArrayList<User> gerans =(ArrayList<User>) urepo.getGerants();
		if (gerans.size()!=0){
		int min=999999999;
		for(User g : gerans){
		
			   if(g.getReclams().size()<min){
				  gerant=g;
			   }		
		}
		}
    	return gerant;
    }


}
