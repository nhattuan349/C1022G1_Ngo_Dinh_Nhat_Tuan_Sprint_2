package com.example.be.repository;

import com.example.be.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "select a.* from  account as a where a.email= :email", nativeQuery = true)
    Account findAccountByEmail(@Param("email") String email);

    @Modifying
    @Query(value = "update account set password= :passwordConfirm where account_id= :id", nativeQuery = true)
    void updateAccount(@Param("id") Long id,
                       @Param("passwordConfirm") String passwordConfirm);


    /**
     * Create by : NuongHT
     * Date create: 27/02/2023
     * Description: create query get account by accountID and save newPass allow accountID
     *
     * @param 'accountId'
     * @return account
     */
    @Query(value = "select * from account where account_id = :accountId", nativeQuery = true)
    Account findByUserId(@Param("accountId") Long accountId);


//    @Query(value = "update account set password = :newPass where account_id= :accountId",nativeQuery = true)
//    void savePass(@Param("accountId") Long accountId);
}
