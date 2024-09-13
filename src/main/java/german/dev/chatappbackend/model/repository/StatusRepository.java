package german.dev.chatappbackend.model.repository;

import german.dev.chatappbackend.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
