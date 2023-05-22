package com.example.be.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ChangePasswordDto implements Validator {
    private Long accountId;
    @NotNull
    @Size(min = 9,max = 30,message = "Hãy nhập ít nhất 9 - 30 ký tự. ")
    @Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[ -/:-@\\[-`{-~]).",message = "Format validator")
    private String newPass;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    public ChangePasswordDto() {
    }

    public ChangePasswordDto(Long accountId, String newPass) {
        this.accountId = accountId;
        this.newPass = newPass;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
}
