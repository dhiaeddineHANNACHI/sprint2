package Sprint2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sprint2.entities.Notification;
import Sprint2.interfaces.NotificationInterface;
import Sprint2.repositories.NotificationRepository;

@Service
public class NotificationService implements NotificationInterface{
	
	@Autowired
	NotificationRepository notifRepo;

	@Override
	public List<Notification> retrieveAllNotifications() {
		return (List<Notification>) notifRepo.findAll();
	}

	@Override
	public Notification addNotification(Notification n) {
		return notifRepo.save(n);
	}

	@Override
	public void deleteNotification(int id) {
		notifRepo.removeNotificationById(id);
		
	}

	@Override
	public Notification updateNotification(Notification n) {
		return notifRepo.save(n);
	}

	@Override
	public Notification retrieveNotification(int id) {
		return notifRepo.getNotificationById(id);
	}

}
