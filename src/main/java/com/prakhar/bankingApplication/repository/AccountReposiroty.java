package com.prakhar.bankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prakhar.bankingApplication.models.Accounts;

@Repository
public interface AccountReposiroty extends JpaRepository<Accounts,Long> {

}
