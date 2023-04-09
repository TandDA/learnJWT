package net.gukinon.learnJWT.repository;

import net.gukinon.learnJWT.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Integer> {
    Permission findByName(String name);
}
