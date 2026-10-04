package com.prakhar.bankingApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prakhar.bankingApplication.models.Accounts;
import com.prakhar.bankingApplication.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	
	private final AccountService accountService;
	
	 public AccountController(AccountService accountService) {
		 this.accountService=accountService;
	 }
	 @PostMapping("/createAccount")
	 public ResponseEntity<Accounts> addAccount(@RequestBody Accounts accounts) {
		 Accounts savedAccount = accountService.createAccount(accounts);
	        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);		 
	 }
	 
	 @DeleteMapping("/deleteAccount/{accountNumber}")
	 public ResponseEntity<Void> deleteAccount(@PathVariable long accountNumber) {
		boolean isDeleted=accountService.deleteAccount(accountNumber);
		if (!isDeleted) {
            return new ResponseEntity<>(HttpStatus.MULTI_STATUS);  // 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404 Not Found if account is not found
        }	 
	 }
	 
	 @GetMapping("/getAccount/{accountNumber}")
	 public ResponseEntity<Accounts> getAccount(@PathVariable long accountNumber) {
		 Accounts accounts=accountService.getAccountById(accountNumber);
		if (accounts!=null) {
            return new ResponseEntity<>(accounts,HttpStatus.OK);  // 204 No Content
        } else {
            return new ResponseEntity<>(accounts,HttpStatus.NOT_FOUND);  // 404 Not Found if account is not found
        }	 
	 }
	
	 
	 @GetMapping("/getAllAccount")
	 public ResponseEntity<List<Accounts>> getAllAccount() {
		 List<Accounts> accountList=accountService.getAllAccount();
		if (!accountList.isEmpty()) {
            return new ResponseEntity<>(accountList,HttpStatus.OK);  // 204 No Content
        } else {
            return new ResponseEntity<>(accountList,HttpStatus.NOT_FOUND);  // 404 Not Found if account is not found
        }	 
	 }

}
