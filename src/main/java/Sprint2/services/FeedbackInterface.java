package Sprint2.services;

import java.util.List;


import Sprint2.entities.Feedback;
import Sprint2.entities.Notification;;

public interface FeedbackInterface {
	 List<Feedback> retrieveAllFeedbacks();
	 Feedback addFeedback(Feedback f);
	 void deleteFeedback(int id);
	 Feedback updateFeedback(Feedback f);
	 Feedback retrieveFeedback(int id);
}
