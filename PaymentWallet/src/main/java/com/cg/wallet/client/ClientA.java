package com.cg.wallet.client;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.wallet.dto.TransferForm;
import com.cg.wallet.dto.TxnForm;
import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.entity.WalletTransaction;
import com.cg.wallet.exceptions.AccountNotFoundException;
import com.cg.wallet.exceptions.LoginException;
import com.cg.wallet.exceptions.WalletTXNNotFouException;
import com.cg.wallet.exceptions.WalletTxnException;
import com.cg.wallet.service.AddWalletService;
import com.cg.wallet.service.LoginService;
import com.cg.wallet.service.TransferFundService;
import com.cg.wallet.service.ViewWalletService;

public class ClientA {

	public static void main(String[] args) throws AccountNotFoundException, WalletTxnException, WalletTXNNotFouException, LoginException {
		
		  ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfiguration.class);
		  AddWalletService service = ctx.getBean(AddWalletService.class);
		 
		/*
		 * TransferFundService tservice = ctx.getBean(TransferFundService.class);
		 * 
		 * TransferForm form = new TransferForm(); form.setAmt(100);
		 * form.setFromaccountID("8146089998"); form.setToAccountID("7087524455");
		 * 
		 * TransferForm form2 = new TransferForm(); form2.setAmt(100);
		 * form2.setFromaccountID("8146089998"); form2.setToAccountID("7013625372");
		 */
		  
		
		
		 WalletAccount account1 = new WalletAccount(); account1.setBalance(500000);
		  account1.setPassword("svsksvsk"); account1.setPhoneNo("7013625372");
		  account1.setUserName("svsksai"); service.createAccount(account1);
		 
		
		
		/*
		  WalletAccount account = new WalletAccount(); TxnForm txnForm = new TxnForm();
		  txnForm.setAmount(500000); txnForm.setWalletAccountId("7013625372");
		  account.setBalance(200); account.setPassword("svsk1234");
		  account.setPhoneNo("9949713956"); account.setUserName("RamaRaju");
		  service.createAccount(account); service.addAmountToWalletAccount(txnForm);
		 
		 
		 
		
		
		
		/*
		 * WalletAccount act=new WalletAccount(); act.setPhoneNo("9949713956");
		 * TransferFundService transferService = ctx.getBean(TransferFundService.class);
		 * TransferForm tf = new TransferForm(); tf.setFromaccountID("9917134477");
		 * tf.setToAccountID("9949713956"); tf.setAmt(500);
		 * transferService.transferFund(tf);
		 */
		  
		  
		/*
		 * LoginService loginService = ctx.getBean(LoginService.class);
		 * System.out.println(loginService.doLogin("9949713956", "svsk1234"));
		 */
		 
		  
	}

}
