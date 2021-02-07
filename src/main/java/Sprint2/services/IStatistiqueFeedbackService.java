package Sprint2.services;

import java.util.List;

import Sprint2.entities.Feedback;

public interface IStatistiqueFeedbackService {

	List<Feedback> listeFb();
	List<Feedback> listeFbParId(int id_fb);
	long NbrFb();



}
