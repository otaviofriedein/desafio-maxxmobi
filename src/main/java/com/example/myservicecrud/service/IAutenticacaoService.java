package com.example.myservicecrud.service;

import com.example.myservicecrud.dto.LoginUserDto;
import com.example.myservicecrud.dto.RegisterUserDto;
import com.example.myservicecrud.entity.User;

public interface IAutenticacaoService {

    User signup(RegisterUserDto input);

    User authenticate(LoginUserDto input);
}
