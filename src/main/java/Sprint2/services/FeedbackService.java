package Sprint2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sprint2.entities.Feedback;

import Sprint2.services.FeedbackInterface;
import Sprint2.repositories.FeedbackRepository;


@Service
public class FeedbackService implements FeedbackInterface{
	@Autowired
	FeedbackRepository fbRepo; 
	@Override
	public List<Feedback> retrieveAllFeedbacks() {
		return (List<Feedback>) fbRepo.findAll();
	}

	@Override
	public Feedback addFeedback(Feedback f) {
		return fbRepo.save(f);
	}

	@Override
	public void deleteFeedback(int id) {
		fbRepo.removeFeedbackById(id);
		
	}

	@Override
	public Feedback updateFeedback(Feedback f) {
		return fbRepo.save(f);
	}

	@Override
	public Feedback retrieveFeedback(int id) {
		return fbRepo.getFeedbackById(id);
	}

}
