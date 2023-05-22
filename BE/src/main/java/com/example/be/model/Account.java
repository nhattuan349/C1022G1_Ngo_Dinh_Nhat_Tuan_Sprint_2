package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String password = "123123124";
    private String name;
    @Column(columnDefinition = "varchar(255)", unique = true, nullable = false)
    private String email;
    private Boolean flagDelete;
    private String avatar;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Set<AccountRole> accountRoleSet;

    public Account() {
    }

    public Account(Long accountId, String password, String name, String email, Boolean flagDelete, String avatar, Set<AccountRole> accountRoleSet) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.flagDelete = flagDelete;
        this.avatar = avatar;
        this.accountRoleSet = accountRoleSet;
    }

    public Account(Long accountId) {
        this.accountId = accountId;
    }

    public Account(String name) {
        this.name = name;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<AccountRole> getAccountRoleSet() {
        return accountRoleSet;
    }

    public void setAccountRoleSet(Set<AccountRole> accountRoleSet) {
        this.accountRoleSet = accountRoleSet;
    }
}
