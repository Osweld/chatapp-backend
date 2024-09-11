package german.dev.chatappbackend.model.repository;

import german.dev.chatappbackend.model.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
}
