package net.gukinon.learnJWT.repository;

import net.gukinon.learnJWT.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String name);
}
