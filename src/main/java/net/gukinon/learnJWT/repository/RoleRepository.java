package net.gukinon.learnJWT.repository;

import net.gukinon.learnJWT.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface RoleRepository extends ListCrudRepository<Role,Integer> {
    Role findByName(String name);
}
