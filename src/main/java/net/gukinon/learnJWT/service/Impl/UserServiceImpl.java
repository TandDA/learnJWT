package net.gukinon.learnJWT.service.Impl;

import lombok.extern.slf4j.Slf4j;
import net.gukinon.learnJWT.model.Role;
import net.gukinon.learnJWT.model.UserEntity;
import net.gukinon.learnJWT.repository.RoleRepository;
import net.gukinon.learnJWT.repository.UserRepository;
import net.gukinon.learnJWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        Role userRole = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(userRole);

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRoles(userRoles);

        UserEntity registeredUserEntity = userRepository.save(userEntity);
        return registeredUserEntity;
    }

    @Override
    public List<UserEntity> getAll() {
        List<UserEntity> result = userRepository.findAll();
        return result;
    }

    @Override
    public UserEntity findByUsername(String username) {
        UserEntity result = userRepository.findByUsername(username);
        return result;
    }

    @Override
    public UserEntity findById(Integer id) {
        UserEntity result = userRepository.findById(id).orElse(null);

        return result;
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);

    }
}
