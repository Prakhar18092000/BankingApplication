package com.prakhar.bankingApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prakhar.bankingApplication.models.Accounts;
import com.prakhar.bankingApplication.repository.AccountReposiroty;

@Service
public class AccountService {
  private final AccountReposiroty accountRepository;
  
  public AccountService (AccountReposiroty accountRepository ) {
	this.accountRepository = accountRepository;  
  }

  public Accounts createAccount(Accounts account) {
      // Saving the account to the database
      return accountRepository.save(account);
  }
  
  public boolean deleteAccount(long accountNumber) {
      if(accountRepository.existsById(accountNumber)) {
      	accountRepository.deleteById(accountNumber);
      	return true;
      }else {
      return false;
      }
  }

public Accounts getAccountById(long accountNumber) {
	
	return accountRepository.findById(accountNumber).orElseThrow(()-> new IllegalArgumentException("Invalid Account ID"));
}

public List<Accounts> getAllAccount() {
	// TODO Auto-generated method stub
	return accountRepository.findAll();
}
  
  
}
