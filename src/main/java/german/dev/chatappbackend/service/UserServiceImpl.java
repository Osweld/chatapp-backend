package german.dev.chatappbackend.service;

import german.dev.chatappbackend.exception.UserNotFoundException;
import german.dev.chatappbackend.model.projection.UserProjection;
import german.dev.chatappbackend.model.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserProjection findById(Long idUser) {
        return userRepository.findUserById(idUser).orElseThrow(()->
                new UserNotFoundException("User with id: " + idUser + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public UserProjection findByUsername(String username) {
        return userRepository.findUserByUsername(username).orElseThrow(()->
                new UserNotFoundException("User with username: " + username + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserProjection> searchUserByUsername(String username) {
        Pageable pageable = PageRequest.of(0,5);
        List<UserProjection> users = userRepository.searchByUsername(username, pageable).stream().toList();
        if (users.isEmpty()) {
            throw new UserNotFoundException("No users found with username containing '" + username + "'");
        }
        return users;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserProjection> findAllUsers(int page, int size) {
        return userRepository.findAllUsers(PageRequest.of(page, size));
    }
}
