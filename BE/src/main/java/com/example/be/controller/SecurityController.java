package com.example.be.controller;


import com.example.be.jwt.JwtUtility;
import com.example.be.payload.request.LoginRequest;
import com.example.be.payload.response.JwtResponse;
import com.example.be.service.IAccountService;
import com.example.be.service.impl.AccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/public")
@CrossOrigin("*")
public class SecurityController {

    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IAccountService accountService;

    /**
     * Created by: TienP
     * Date created: 29/03/2023
     * Function:  authenticate user
     * @param: loginRequest
     * @return: HttpStatus.No_Content if result is error or HttpStatus.OK is result is not error
     */

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtility.generateJwtToken(loginRequest.getUsername());
        AccountDetails userDetails = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        JwtResponse jwtResponse = new JwtResponse(
                jwt,
                userDetails.getUsername(),
                userDetails.getName(),
                userDetails.getAccountId(),
                roles);
        return ResponseEntity.ok(
                jwtResponse
        );
    }
}
