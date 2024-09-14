package german.dev.chatappbackend.service;

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
        return userRepository.findUserById(idUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserProjection findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserProjection> searchUserByUsername(String username) {
        Pageable pageable = PageRequest.of(0,5);
        return userRepository.searchByUsername(username, pageable).stream().toList();
    }

    @Override
    public Page<UserProjection> findAllUsers(int page, int size) {
        return userRepository.findAllUsers(PageRequest.of(page, size));
    }
}
