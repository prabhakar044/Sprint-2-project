package com.cg.wallet.dao;

import java.time.LocalDate;
import java.util.List;

import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.entity.WalletTransaction;

public interface IWalletDao {
	
	
	public boolean addWalletAccount(WalletAccount account);
	public boolean editWalletAccount(WalletAccount account);
	public WalletAccount getWalletAccount(String walletAccountId);
	public boolean addWalletTransaction(WalletTransaction walletTxn);
	public List<WalletTransaction> getWalletTransactions(String walletUSerId);
	public List<WalletTransaction> getWalletTransactions(String walletUSerId, int txns);
	public List<WalletTransaction> getWalletTransactions(String walletUSerId, LocalDate fromDt, LocalDate toDate);
	

}
