package Sprint2.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Sprint2.entities.*;


@Repository
public interface NotificationRepository extends CrudRepository<Notification, Integer>{
	
	@Query("Select n from Notification n WHERE n.id_notif = :id")
	Notification getNotificationById(@Param("id") int id);
	
	@Query("DELETE FROM Notification n WHERE n.id_notif = :id")
	Void removeNotificationById(@Param("id") int id);
	
}
