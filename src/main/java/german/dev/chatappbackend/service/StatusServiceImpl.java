package german.dev.chatappbackend.service;

import german.dev.chatappbackend.model.entity.Status;
import german.dev.chatappbackend.model.repository.StatusRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }
}
