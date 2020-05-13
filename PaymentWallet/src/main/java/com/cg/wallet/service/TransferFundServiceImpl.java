package com.cg.wallet.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.wallet.dao.IWalletDao;
import com.cg.wallet.dto.TransferForm;
import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.entity.WalletTransaction;
import com.cg.wallet.exceptions.AccountNotFoundException;
import com.cg.wallet.exceptions.WalletTxnException;
import com.cg.wallet.util.WalletConstants;

@Service("accountser")
@Transactional
public class TransferFundServiceImpl implements TransferFundService {

	@Autowired
	private IWalletDao dao;


/*******************************************
	 * Method:transferfund
     *Description: Transfer amount from one account to another
	 * @param name   - Transform ref which contains fromAccId,toAccId,amount.
	 * @returns      -boolean 
	 * @throws AccountNotFoundException, WalletTxnException- if Account not found 
     *Created By    - Lovaraju
     *                         	 
	 ********************************************/
   // @Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public boolean transferFund(TransferForm transferForm) throws AccountNotFoundException, WalletTxnException {
		WalletAccount fromAccount = dao.getWalletAccount(transferForm.getFromaccountID());
		if (fromAccount == null)
			throw new AccountNotFoundException(WalletConstants.INVALID_ACCOUNT);
		WalletAccount toAccount = dao.getWalletAccount(transferForm.getToAccountID());
		if (toAccount == null)
			throw new AccountNotFoundException(WalletConstants.INVALID_ACCOUNT);
		if (fromAccount.getBalance() < transferForm.getAmt())
			throw new WalletTxnException(WalletConstants.INSUFFICIENT_BALANCE);
		fromAccount.setBalance(fromAccount.getBalance() - transferForm.getAmt());
		toAccount.setBalance(toAccount.getBalance() + transferForm.getAmt());
		
		dao.editWalletAccount(fromAccount);
		addTxn(fromAccount, transferForm.getAmt(), WalletConstants.DEBIT, WalletConstants.TRANSFERED_TO + toAccount.getPhoneNo(),fromAccount.getPhoneNo());
				
		dao.editWalletAccount(toAccount);
		addTxn(toAccount, transferForm.getAmt(), WalletConstants.CREDIT, WalletConstants.TRANSFERED_FROM + fromAccount.getPhoneNo(), toAccount.getPhoneNo());
		return true;
	}


/*******************************************
	 * Method:addtxn
     *Description: adds a transaction  when transfer is successful
	 * @param name   - account, amount, txType, description,phoneNo
	 * @returns      -boolean 
     *Created By    - Lovaraju
     *                           	 
	 ********************************************/
   // @Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean addTxn(WalletAccount account, double amount, String txType, String description, String phoneNo) {
		WalletTransaction walletTxn = new WalletTransaction();
		walletTxn.setDescription(description);
		walletTxn.setDateOfTranscation(LocalDate.now());
		walletTxn.setTxType(txType);
		walletTxn.setAmount(amount);
		walletTxn.setAccount(account);
		dao.addWalletTransaction(walletTxn);
		return true;
	}
}