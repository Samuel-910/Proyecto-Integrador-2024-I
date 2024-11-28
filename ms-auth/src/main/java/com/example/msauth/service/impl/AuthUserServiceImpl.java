package com.example.msauth.service.impl;

import com.example.msauth.dto.AuthUserDto;
import com.example.msauth.entity.AuthUser;
import com.example.msauth.entity.Role;
import com.example.msauth.entity.TokenDto;

import com.example.msauth.repository.AuthUserRepository;
import com.example.msauth.repository.RoleRepository;
import com.example.msauth.security.JwtProvider;
import com.example.msauth.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class AuthUserServiceImpl implements AuthUserService {
    @Autowired
    AuthUserRepository authUserRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AuthUser save(AuthUserDto authUserDto) {
        Optional<AuthUser> user = authUserRepository.findByUserName(authUserDto.getUserName());
        if (user.isPresent())
            return null;

        // Codificar la contraseña
        String password = passwordEncoder.encode(authUserDto.getPassword());

        // Buscar el rol "PRACTICANTE" por ID (o por nombre)
        Role rolePract = roleRepository.findById(3)
                .orElseThrow(() -> new RuntimeException("Rol PRACTICANTE no encontrado"));

        // Crear el usuario con el rol asignado
        AuthUser authUser = AuthUser.builder()
                .userName(authUserDto.getUserName())
                .password(password)
                .build();

        // Asignar el rol al usuario
        Set<Role> roles = new HashSet<>();
        roles.add(rolePract);
        authUser.setRoles(roles);

        // Guardar el usuario junto con sus roles
        return authUserRepository.save(authUser);
    }



    @Override
    public TokenDto login(AuthUserDto authUserDto) {
        Optional<AuthUser> user = authUserRepository.findByUserName(authUserDto.getUserName());
        if (!user.isPresent())
            return null;
        if (passwordEncoder.matches(authUserDto.getPassword(), user.get().getPassword()))
            return new TokenDto(jwtProvider.createToken(user.get()));
        return null;
    }


    @Override
    public TokenDto validate(String token) {
        if (!jwtProvider.validate(token))
            return null;
        String username = jwtProvider.getUserNameFromToken(token);
        if (!authUserRepository.findByUserName(username).isPresent())
            return null;
        return new TokenDto(token);
    }

    public AuthUserDto getUserDetails(String token) {
        String username = jwtProvider.getUserNameFromToken(token);
        if (username.equals("bad token")) {
            return null; // Manejo del error en caso de token inválido
        }
        Optional<AuthUser> authUser = authUserRepository.findByUserName(username);

        if (authUser != null) {
            AuthUserDto authUserDto = new AuthUserDto();
            authUserDto.setId(authUser.get().getId());
            authUserDto.setUserName(authUser.get().getUserName());
            return authUserDto;
        }
        return null;
    }

    public void assignRolesToUser(int userId, List<Integer> roleIds) {
        AuthUser user = authUserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Set<Role> roles = new HashSet<>(roleRepository.findAllById(roleIds));

        user.setRoles(roles);
        authUserRepository.save(user);
    }

    public List<AuthUser> obtenerTodosLosUsuarios() {
        return authUserRepository.findAll();
    }

    public List<Role> obtenerTodosLosRoles() {
        return roleRepository.findAll();
    }
}
