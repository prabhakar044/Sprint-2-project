package com.cg.wallet.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.wallet.dao.IWalletDao;
import com.cg.wallet.dto.TxnForm;
import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.entity.WalletTransaction;
import com.cg.wallet.util.WalletConstants;

@Transactional
@Service("addwalletser")
public class AddWalletServiceImpl implements AddWalletService {

	@Autowired
	private IWalletDao dao;

	/****************************
	 * 
	 * @Author Name  : sai sumanth
	 * Method Name   : addAmountToWalletAccount
	 * Description   : adds the given amount into WalletAccount
	 * @param  		 : TxnForm
	 * @return 	     : boolean
	 * 
	 ****************************/
	
	@Override
	public boolean addAmountToWalletAccount(TxnForm txnForm) {

		WalletAccount account = dao.getWalletAccount(txnForm.getWalletAccountId());
		account.setBalance(account.getBalance() + txnForm.getAmount());
		WalletTransaction tx = new WalletTransaction();
		tx.setTxType(WalletConstants.CREDIT);
		tx.setDateOfTranscation(LocalDate.now());
		tx.setAmount(txnForm.getAmount());
		tx.setDescription(WalletConstants.AMOUNT_ADDED_TO_WALLET);
		tx.setAccount(account);
		dao.addWalletTransaction(tx);
		dao.editWalletAccount(account);
		return true;
	}
	
	/****************************
	 * 
	 * @Author Name  : Prabhakar
	 * Method Name   : createAccount
	 * Description   : creates the wallet account  for the given user details
	 * @param  		 : WalletAccount
	 * @return 	     : boolean
	 * 
	 ****************************/

	@Override
	public boolean createAccount(WalletAccount account) {
		account.setRole(WalletConstants.ROLE_USER);
		account.setStatus(WalletConstants.WALLET_ACTIVE);
		account.setAccCreatedDt(LocalDate.now());
		dao.addWalletAccount(account);
		if(account.getBalance()> WalletConstants.AMOUNT_ZERO) {
			WalletTransaction tx = new WalletTransaction();
			tx.setTxType(WalletConstants.CREDIT);
			tx.setDateOfTranscation(LocalDate.now());
			tx.setAmount(account.getBalance());
			tx.setDescription(WalletConstants.AMOUNT_ADDED_TO_WALLET);
			tx.setAccount(account);
			dao.addWalletTransaction(tx);
		}
			
		return true;
	}
	
	/****************************
	 * 
	 * @Author Name  : Prabhakar
	 * Method Name   : getAccount
	 * Description   : getting WalletAccount from accountId
	 * @param  		 : String walletAccountId
	 * @return 	     : WalletAccount
	 * 
	 ****************************/
	@Override
	public WalletAccount getAccount(String walletAccountId) {
		
		return dao.getWalletAccount(walletAccountId);
	}
	
	/****************************
	 * 
	 * @Author Name  : Sai Sumanth
	 * Method Name   : showBalance
	 * Description   : gives the amount in the WalletAccount
	 * @param  		 : String walletAccountId
	 * @return 	     : balance
	 * 
	 ****************************/
	
	@Override
	public double showBalance(String walletAccountId) {
		return dao.getWalletAccount(walletAccountId).getBalance();
	}

}
