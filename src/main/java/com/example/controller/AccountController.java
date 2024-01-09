package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.resource.RequestAmount;
import com.example.resource.ResponseAmount;
import com.example.service.AccountService;

@RestController
@RequestMapping("/bankTrading")
public class AccountController {
	private final AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@PostMapping("/open")
	public Account open() {
		return this.accountService.create();
	}

	@GetMapping("/{account_id}")
	public ResponseAmount getAmount(@PathVariable("account_id") Integer accountId) {
		return this.accountService.getResponseAmount(accountId);
	}

	@PostMapping("/deposit/{account_id}")
	public ResponseAmount deposit(@PathVariable("account_id") Integer accountId
			, @RequestBody RequestAmount requestAmount) {
		return this.accountService.depositAccount(accountId, requestAmount);
	}

	@PostMapping("/withdraw/{account_id}")
	public ResponseAmount withdraw(@PathVariable("account_id") Integer accountId
			, @RequestBody RequestAmount requestAmount) {
		return this.accountService.withdrawAccount(accountId, requestAmount);
	}
}
