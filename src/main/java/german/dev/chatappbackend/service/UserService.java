package german.dev.chatappbackend.service;

import german.dev.chatappbackend.model.projection.UserProjection;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    UserProjection findById(Long idUser);
    UserProjection findByUsername(String username);
    List<UserProjection> searchUserByUsername(String username);
    Page<UserProjection> findAllUsers(int page, int size);



}
