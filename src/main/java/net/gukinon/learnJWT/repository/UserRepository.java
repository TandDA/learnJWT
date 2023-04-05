package net.gukinon.learnJWT.repository;

import net.gukinon.learnJWT.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUsername(String name);
    Boolean existsByUsername(String username);
}
