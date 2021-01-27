package Sprint2.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Sprint2.entities.Feedback;
import Sprint2.exception.ResourceNotFoundException;
import Sprint2.services.FeedbackService;

import javax.validation.Valid;



@RestController
@RequestMapping("/manageFeedbaks")
public class FeedbackController {

	@Autowired
    private  FeedbackService fbService;
	
	@GetMapping(value = "/feedbacks")
	public List<Feedback> getAllFeedbacks  () throws ResourceNotFoundException
	{
		
	    return  fbService.retrieveAllFeedbacks();
	}
	
	@GetMapping("/feedback/{id}")
	public Feedback getFeedbackById(@PathVariable(value = "id") int id) throws ResourceNotFoundException
	{
		return  fbService.retrieveFeedback(id);
	}

	@PostMapping(value = "/newFeedback")
	public Feedback newFeedback(@Valid @RequestBody Feedback feedback)  throws ResourceNotFoundException
	{
		return fbService.addFeedback(feedback);
	}

	@PutMapping(value = "/updateFeedback")
	public Feedback UpdateFeedback(@RequestBody Feedback feedback)  throws ResourceNotFoundException {
		 return fbService.updateFeedback(feedback);
	}
	

	@DeleteMapping("/deleteFeedback/{id}")
	public void deleteFeedbackById(@PathVariable(value = "id") int id)  throws ResourceNotFoundException
	{
        fbService.deleteFeedback(id);
	}
	
}
