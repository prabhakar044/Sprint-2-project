package com.cg.wallet.service;

import com.cg.wallet.dto.TransferForm;
import com.cg.wallet.exceptions.AccountNotFoundException;
import com.cg.wallet.exceptions.WalletTxnException;

public interface TransferFundService {

	public boolean transferFund(TransferForm transferForm) throws AccountNotFoundException, WalletTxnException;
}
