package com.example.myservicecrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.myservicecrud.dto.LoginUserDto;
import com.example.myservicecrud.dto.RegisterUserDto;
import com.example.myservicecrud.entity.User;
import com.example.myservicecrud.responses.LoginResponse;
import com.example.myservicecrud.service.IAutenticacaoService;
import com.example.myservicecrud.service.ITokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private IAutenticacaoService autenticacaoService;   
    @Autowired
    private ITokenService tokenService;  

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto usuarioDTO) {
        User registeredUser = autenticacaoService.signup(usuarioDTO);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {

        User authenticatedUser = autenticacaoService.authenticate(loginUserDto);          

        String jwtToken = tokenService.generateToken(authenticatedUser);              
        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(tokenService.getExpirationTime()); 

        return ResponseEntity.ok(loginResponse);
    }
}