package com.prakhar.bankingApplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Accounts {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
     private long accountNumber;
	 private String accountHolderName;
	 private double balance;

}
