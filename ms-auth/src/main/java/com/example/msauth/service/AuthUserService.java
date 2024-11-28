package com.example.msauth.service;
import com.example.msauth.dto.AuthUserDto;
import com.example.msauth.entity.AuthUser;
import com.example.msauth.entity.Role;
import com.example.msauth.entity.TokenDto;

import java.util.List;


public interface AuthUserService {
    public AuthUser save(AuthUserDto authUserDto);


    public TokenDto login(AuthUserDto authUserDto);


    public TokenDto validate(String token);

    public AuthUserDto getUserDetails(String token);

    public void assignRolesToUser(int userId, List<Integer> roleIds);

    public List<AuthUser> obtenerTodosLosUsuarios();

    public List<Role> obtenerTodosLosRoles();
}
