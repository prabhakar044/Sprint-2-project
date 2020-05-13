package com.cg.wallet.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.wallet.dto.ErrorMessage;
import com.cg.wallet.exceptions.AccountNotFoundException;
import com.cg.wallet.exceptions.LoginException;
import com.cg.wallet.exceptions.WalletTXNNotFouException;
import com.cg.wallet.exceptions.WalletTxnException;

@RestControllerAdvice
public class WalletExceptionAdvice {
	@ExceptionHandler({WalletTXNNotFouException.class, AccountNotFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleNotFoundException(Exception ex) {
		return new ErrorMessage(ex.getMessage());
		
	}
	
	@ExceptionHandler({WalletTxnException.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleBadREquestException(Exception ex) {
		return new ErrorMessage(ex.getMessage());
		
	}
	
	@ExceptionHandler({LoginException.class})
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public ErrorMessage handleForbiddentException(Exception ex) {
		return new ErrorMessage(ex.getMessage());
		
	}


}
