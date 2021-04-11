package com.hcl.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.account.model.FavourateAccountsEntity;
 
@Repository
public interface FavourateAccountRepository
        extends JpaRepository<FavourateAccountsEntity, Long> {
 
}
