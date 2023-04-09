package net.gukinon.learnJWT.service;

import net.gukinon.learnJWT.model.Permission;
import net.gukinon.learnJWT.model.UserEntity;

import java.util.List;

public interface PermissionService {
    Permission create(Permission permission);
    List<Permission> getAll();
    Permission findByName(String name);
    Permission findById(Integer id);
    void deleteById(Integer id);
}
