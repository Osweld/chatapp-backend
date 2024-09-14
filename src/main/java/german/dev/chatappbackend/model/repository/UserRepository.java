package german.dev.chatappbackend.model.repository;

import german.dev.chatappbackend.model.entity.User;
import german.dev.chatappbackend.model.projection.UserProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u.id as id, u.username as username, u.email as email, u.createdAt as createdAt, r.name as rol, s.name as status " +
            "FROM User u JOIN u.rol r JOIN u.status s WHERE u.id = :id")
    UserProjection findUserById(Long id);

    @Query("SELECT u.id as id, u.username as username, u.email as email, u.createdAt as createdAt, r.name as rol, s.name as status " +
            "FROM User u JOIN u.rol r JOIN u.status s WHERE u.username = :username")
    UserProjection findUserByUsername(String username);

    @Query("SELECT u.id as id, u.username as username, u.email as email, u.createdAt as createdAt, r.name as rol, s.name as status " +
            "FROM User u JOIN u.rol r JOIN u.status s WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :username, '%'))")
    Page<UserProjection> searchByUsername(String username, Pageable pageable);

    @Query("SELECT u.id as id, u.username as username, u.email as email, u.createdAt as createdAt, r.name as rol, s.name as status " +
            "FROM User u JOIN u.rol r JOIN u.status s")
    Page<UserProjection> findAllUsers(Pageable pageable);
}
