package com.cg.wallet.service;

import com.cg.wallet.dto.TxnForm;
import com.cg.wallet.entity.WalletAccount;

public interface AddWalletService {
	public boolean createAccount(WalletAccount account);
	public boolean addAmountToWalletAccount(TxnForm txnForm);
	public WalletAccount getAccount(String walletId);
	public double showBalance(String walletAccountId);
}
