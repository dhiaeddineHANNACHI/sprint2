package Sprint2.services;

import java.util.List;



import Sprint2.entities.Notification;

public interface NotificationInterface {
	
	 List<Notification> retrieveAllNotifications();
	 Notification addNotification(Notification n);
	 void deleteNotification(int id);
	 Notification updateNotification(Notification n);
	 Notification retrieveNotification(int id);
	
}
