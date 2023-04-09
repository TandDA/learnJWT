package net.gukinon.learnJWT.controller;

import net.gukinon.learnJWT.dto.AuthResponseDto;
import net.gukinon.learnJWT.dto.LoginDto;
import net.gukinon.learnJWT.dto.RegisterDto;
import net.gukinon.learnJWT.model.Role;
import net.gukinon.learnJWT.model.Status;
import net.gukinon.learnJWT.model.UserEntity;
import net.gukinon.learnJWT.repository.RoleRepository;
import net.gukinon.learnJWT.repository.UserRepository;
import net.gukinon.learnJWT.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthControllerV1 {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthControllerV1(AuthenticationManager authenticationManager, UserRepository userRepository,
                            RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserEntity user = userRepository.findByUsername(loginDto.getUsername());
        String token = jwtTokenProvider.generateToken(user.getUsername(),user.getRoles().get(0));
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }
}
