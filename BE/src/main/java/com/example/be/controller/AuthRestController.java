package com.example.be.controller;

import com.example.be.dto.ChangePasswordDto;
import com.example.be.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthRestController {

    @Autowired
    private AccountService accountService;

    /**
     * Create by : NuongHT
     * Date create: 28/02/2023
     * Description: api change password
     *
     */
    @PatchMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePasswordDto) throws Exception {
        accountService.changePassword(changePasswordDto);
        return ResponseEntity.ok().build();
    }
}
