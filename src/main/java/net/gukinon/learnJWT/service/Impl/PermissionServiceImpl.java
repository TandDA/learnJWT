package net.gukinon.learnJWT.service.Impl;

import net.gukinon.learnJWT.model.Permission;
import net.gukinon.learnJWT.model.UserEntity;
import net.gukinon.learnJWT.repository.PermissionRepository;
import net.gukinon.learnJWT.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionRepository permissionRepository;

    @Override
    public Permission create(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public List<Permission> getAll() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission findByName(String name) {
        return permissionRepository.findByName(name);
    }

    @Override
    public Permission findById(Integer id) {
        return permissionRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        permissionRepository.deleteById(id);
    }
}
