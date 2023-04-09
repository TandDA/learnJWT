package net.gukinon.learnJWT.controller;

import net.gukinon.learnJWT.dto.RegisterDto;
import net.gukinon.learnJWT.model.Role;
import net.gukinon.learnJWT.model.Status;
import net.gukinon.learnJWT.model.UserEntity;
import net.gukinon.learnJWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserControllerV1 {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable int id){
        return userService.findById(id);
    }
    @PostMapping("add")
    public UserEntity createUser(@RequestBody RegisterDto registerDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registerDto.getUsername());
        userEntity.setPassword(registerDto.getPassword());
        userEntity.setStatus(Status.ACTIVE);

        return userService.create(userEntity);
    }
    @DeleteMapping("delete/{id}")
    public void deleteUserById(@PathVariable int id){
        userService.deleteById(id);
    }

}
