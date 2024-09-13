package german.dev.chatappbackend.model.repository;

import german.dev.chatappbackend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
