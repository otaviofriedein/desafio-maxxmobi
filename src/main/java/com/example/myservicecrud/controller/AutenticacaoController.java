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
import com.example.myservicecrud.service.AutenticacaoService;
import com.example.myservicecrud.service.TokenService;

@RequestMapping("/auth")
@RestController
public class AutenticacaoController {

        @Autowired
        private TokenService tokenService;        
        private AutenticacaoService autenticacaoService;
    
        public AutenticacaoController(TokenService tokenService, AutenticacaoService autenticacaoService) {
            this.tokenService = tokenService;
            this.autenticacaoService = autenticacaoService;
        }
    
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