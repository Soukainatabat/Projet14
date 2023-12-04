package com.example.type1.repositories;

import com.example.type1.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BankAccountRepository  extends JpaRepository<BankAccount,String> {


}
