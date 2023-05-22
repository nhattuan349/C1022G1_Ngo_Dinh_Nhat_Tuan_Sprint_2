package com.example.be.service.impl;

import com.example.be.dto.ChangePasswordDto;
import com.example.be.model.Account;
import com.example.be.repository.IAccountRepository;
import com.example.be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by: Phạm Tiến
 * Date: 29/03/2023
 * Class: AccountService
 */
@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Account findAccountByEmail(String username) {
        return accountRepository.findAccountByEmail(username);
    }

    public boolean checkOldPassword( String oldPassword, String password){
        return BCrypt.checkpw(oldPassword, password);
    }

    @Override
    public void updateAccount(Account account) {
        accountRepository.updateAccount(account.getAccountId(),account.getPassword());
    }

    @Override
    public void addAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void changePassword(ChangePasswordDto changePasswordDto) throws Exception {
        Account account = accountRepository.findByUserId(changePasswordDto.getAccountId());
        if (account == null) {
            throw new Exception("Account null");
        }
        account.setPassword(passwordEncoder.encode(changePasswordDto.getNewPass()));
        accountRepository.save(account);
    }

    @Override
    public void save(Account account) {

    }


}
