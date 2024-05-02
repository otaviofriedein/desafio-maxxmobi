package com.example.myservicecrud.service;

import java.util.List;

import com.example.myservicecrud.dto.LoginUserDto;
import com.example.myservicecrud.dto.RegisterUserDto;
import com.example.myservicecrud.entity.User;

public interface IAutenticacaoService {

    User signup(RegisterUserDto input);

    User authenticate(LoginUserDto input);
}
