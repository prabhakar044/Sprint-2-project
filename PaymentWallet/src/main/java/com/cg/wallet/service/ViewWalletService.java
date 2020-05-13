package com.cg.wallet.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.wallet.entity.WalletTransaction;
import com.cg.wallet.exceptions.WalletTXNNotFouException;

public interface ViewWalletService {

	/**********************************************************************************
	 * 
	 * @Author Name  : venkata sai kumar
	 * Method Name   : getWalletTransactions
	 * Description   : getting transactions of given user's walletUSerId 
	 * Return Type   : List(List of Transactions)
	 * Parameter 1   : String walletUSerId
	 * @throws       : WalletTXNNotFouException - if number of Transactions is Zero 
	 * 
	 **********************************************************************************/
	public List<WalletTransaction> getWalletTransactions(String walletUSerId)throws WalletTXNNotFouException ;
	
	
	
	/**********************************************************************************
	 * 
	 * @Author Name  : venkata sai kumar
	 * Method Name   : getWalletTransactions
	 * Description   : getting transactions of given user's walletUSerId from fromDtate to toDate
	 * Return Type   : List(List of Transactions)
	 * Parameter 1   : String walletUSerId
	 * Parameter 2   : LocalDate fromDate
	 * Parameter 3   : LocalDate toDate
	 * @throws       : WalletTXNNotFouException - if number of Transactions is Zero
	 * 
	 **********************************************************************************/
	public List<WalletTransaction> getWalletTransactions(String walletUSerId, LocalDate fromDt, LocalDate toDate)throws WalletTXNNotFouException ;
	
	
	
	/**********************************************************************************
	 * 
	 * @Author Name  : venkata sai kumar
	 * Method Name   : getWalletTransactionsTransferedToReceipent
	 * Description   : getting transactions Transfered from walletUSerId To  recepentID
	 * Return Type   : List(List of Transactions)
	 * Parameter 1   : String walletUSerId
	 * Parameter 2   : String recipentID
	 * @throws       : WalletTXNNotFouException - if number of Transactions is Zero
	 * 
	 **********************************************************************************/
	public List<WalletTransaction> getWalletTransactionsTransferedToReceipent(String walletUSerId, String recipentID)throws WalletTXNNotFouException ;
	
	
	
	/**********************************************************************************
	 * 
	 * @Author Name  : venkata sai kumar
	 * Method Name   : getWalletTransactionsTransferedToReceipent
	 * Description   : getting transactions Transfered from walletUSerId To  recepentID between fromDt to toDate 
	 * Return Type   : List(List of Transactions)
	 * Parameter 1   : String walletUSerId
	 * Parameter 2   : String recipentID
	 * Parameter 2   : LocalDate fromDate
	 * Parameter 3   : LocalDate toDate
	 * @throws       : WalletTXNNotFouException - if number of Transactions is Zero
	 * 
	 **********************************************************************************/
	public List<WalletTransaction> getWalletTransactionsTransferedToReceipent(String walletUSerId, String recipentID, LocalDate fromDt, LocalDate toDate)throws WalletTXNNotFouException ;
	
	/**********************************************************************************
	 * 
	 * @Author Name  : venkata sai kumar
	 * Method Name   : getWalletTransactionsRecievedReceipent
	 * Description   : getting transactions Recived from  recipentID of given user's walletUSerId 
	 * Return Type   : List(List of Transactions)
	 * Parameter 1   : String walletUSerId
	 * Parameter 2   : String recipentID
	 * @throws       : WalletTXNNotFouException - if number of Transactions is Zero
	 * 
	 **********************************************************************************/
	public List<WalletTransaction> getWalletTransactionsRecievedReceipent(String walletUSerId, String recipentID)throws WalletTXNNotFouException ;
	
	/**********************************************************************************
	 * 
	 * @Author Name  : venkata sai kumar
	 * Method Name   : getWalletTransactionsReceivedToReceipent
	 * Description   : getting transactions Recived from  recipentID of given user's walletUSerId from fromDtate to toDate
	 * Return Type   : List(List of Transactions)
	 * Parameter 1   : String walletUSerId
	 * Parameter 2   : LocalDate fromDate
	 * Parameter 3   : LocalDate toDate
	 * @throws       : WalletTXNNotFouException - if number of Transactions is Zero
	 * 
	 **********************************************************************************/
	public List<WalletTransaction> getWalletTransactionsReceivedReceipent(String walletUSerId, String recipentID, LocalDate fromDt, LocalDate toDate)throws WalletTXNNotFouException ;
	
	
	
	/**********************************************************************************
	 * 
	 * @Author Name  : venkata sai kumar
	 * Method Name   : getSixMonthsTxn
	 * Description   : getting transactions of given user's walletUSerId from now to last six months
	 * Return Type   : List(List of Transactions)
	 * Parameter 1   : String walletUSerId
	 * @throws       : WalletTXNNotFouException - if number of Transactions is Zero
	 * 
	 **********************************************************************************/
    public List<WalletTransaction> getSixMonthsTxn(String walletUserId)throws WalletTXNNotFouException ;
}
