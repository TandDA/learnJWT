package net.gukinon.learnJWT.service;

import net.gukinon.learnJWT.model.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity register(UserEntity userEntity);
    List<UserEntity> getAll();
    UserEntity findByUsername(String username);
    UserEntity findById(Integer id);
    void deleteById(Integer id);

}
