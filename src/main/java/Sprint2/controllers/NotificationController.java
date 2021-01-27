package Sprint2.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import Sprint2.entities.Notification;
import Sprint2.services.NotificationService;
import Sprint2.exception.ResourceNotFoundException;


@RestController
@RequestMapping("/manageNotifications")
public class NotificationController {

	@Autowired
	NotificationService notfService;
	
	@GetMapping(value = "/notfications")
	public List<Notification> getAllFeedbacks  () throws ResourceNotFoundException
	{
	    return  notfService.retrieveAllNotifications();
	}
	
	@GetMapping("/notfication/{id}")
	public Notification getFeedbackById(@PathVariable(value = "id") int id) throws ResourceNotFoundException
	{
		return  notfService.retrieveNotification(id);
	}

	@PostMapping(value = "/newNotification")
	public Notification newFeedback(@Valid @RequestBody Notification notfication)  throws ResourceNotFoundException
	{
		return notfService.addNotification(notfication);
	}

	@PutMapping(value = "/updateNotification")
	public Notification UpdateFeedback(@RequestBody Notification notfication)  throws ResourceNotFoundException {
		 return notfService.updateNotification(notfication);
	}
	

	@DeleteMapping("/deleteNotification/{id}")
	public void deleteFeedbackById(@PathVariable(value = "id") int id)  throws ResourceNotFoundException
	{
		notfService.deleteNotification(id);
	}
	
	
}
