package net.gukinon.learnJWT.security;


import net.gukinon.learnJWT.model.Role;
import net.gukinon.learnJWT.repository.UserRepository;
import net.gukinon.learnJWT.model.UserEntity;
import net.gukinon.learnJWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private UserService userService;
    @Autowired
    public JwtUserDetailsService(UserService userService){
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByUsername(username);
        if(userEntity == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), mapRoleToAuthorities(userEntity.getRoles().get(0)));
    }
    private Collection<GrantedAuthority> mapRoleToAuthorities(Role roles){
        return roles.getPermissionSet().stream().map(permission ->
                new SimpleGrantedAuthority(permission.getName())).collect(Collectors.toList());
    }
    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
