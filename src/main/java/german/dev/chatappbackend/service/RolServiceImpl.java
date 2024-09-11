package german.dev.chatappbackend.service;

import german.dev.chatappbackend.model.entity.Rol;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolServiceImpl implements RolService{

    private final RolService rolService;

    public RolServiceImpl(RolService rolService) {
        this.rolService = rolService;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Rol> getAllRoles() {
        return rolService.getAllRoles();
    }
}
