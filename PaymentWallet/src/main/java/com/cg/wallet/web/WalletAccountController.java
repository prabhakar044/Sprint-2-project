package com.cg.wallet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.wallet.dto.TxnForm;
import com.cg.wallet.dto.WalletMessage;
import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.exceptions.WalletTxnException;
import com.cg.wallet.service.AddWalletService;
import com.cg.wallet.util.WalletConstants;

@RestController
public class WalletAccountController {
	
	@Autowired
	private AddWalletService walletService;
	
	
	/*******************************************
	 * @author 		   sai sumanth
	 * Method		 : addAmountToWallet
     *Description	 : Add amount to the WalletAccount
	 * @param name   : TxnForm  which contains walletAccountID,amount.
	 * @returns      : WalletMessage i.e.Amount Added Successfully
     *                          	 
	 ********************************************/

	@CrossOrigin
	@PostMapping("/addamount")
	public WalletMessage addAmountToWallet(@RequestBody TxnForm txnForm ) {
		
		walletService.addAmountToWalletAccount(txnForm);
		WalletMessage msg = new WalletMessage(WalletConstants.ACOUNT_ADDED_TO_WALLET);
		return msg;
		
	}
	
	/*******************************************
	 * @author 		   prabhakar
	 * Method		 : addAccount
     *Description	 : Add walletAccount 
	 * @param name   : WalletAccount  
	 * @returns      : WalletMessage i.e.Amount Added Successfully
     *                          	 
	 ********************************************/
	
	@CrossOrigin
	@PostMapping("/addaccount")
	public WalletMessage addAccount(@RequestBody WalletAccount account) throws WalletTxnException {
		try {
		walletService.createAccount(account);
		
		WalletMessage msg = new WalletMessage(WalletConstants.ACCOUNT_CREATED);
		return msg;
		}catch(DataIntegrityViolationException ex) {
			throw new WalletTxnException(WalletConstants.ID_EXISTS);
		}
		
	}
	
	/*******************************************
	 * @author 		   prabhakar
	 * Method		 : getaccountSummary
     *Description	 : Views the account summary
	 * @param name   : walletid  
	 * @returns      : WalletAccount
     *                          	 
	 ********************************************/
	@GetMapping("/accountsummary/{walletid}")
	@CrossOrigin
	public WalletAccount getaccountSummary(@PathVariable("walletid") String walletId) {
		return walletService.getAccount(walletId);
	}
	
	
	/*******************************************
	 * @author 		   sai sumanth
	 * Method		 : showBalance
     *Description	 : Gets the balance for the given account
	 * @param name   : walletid
	 * @returns      : balance
     *                          	 
	 ********************************************/
	@CrossOrigin
	@GetMapping("/showbalance/{walletid}")
	public double showBalance(@PathVariable("walletid") String walletId) {
		return walletService.showBalance(walletId);
	}
}
