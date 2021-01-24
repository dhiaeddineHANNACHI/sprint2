package Sprint2.controller;

import java.util.List;

import Sprint2.Services.StatistiqueFeedbackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Sprint2.entities.Feedback;


@RestController
public class StatFeedbackController {
	
	@Autowired
	private StatistiqueFeedbackServiceImpl sfs;
	
	@GetMapping("/listefeedback")
	public List<Feedback> getAllFeedback() 
	{
		return  (List<Feedback>) sfs.listeFb();
	}
	@GetMapping("/nbrfb")
	public Long nbrfb()
	{
		return (long) sfs.NbrFb();
	}
}
