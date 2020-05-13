package com.cg.wallet.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.entity.WalletTransaction;

@Repository
public class WalletDaoImpl implements IWalletDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	

	@Override
	public boolean addWalletAccount(WalletAccount account) {
		entityManager.persist(account);
		return true;
	}
/**********************************************************************************
	 * 
	 * @Author Name  : lovaraju
	 * Method Name   : editWalletAccount
	 * Description   : when transaction is done fromaccount and toaccount is updated 
	 * Return Type   : boolean
	 * Parameter 1   : WalletAccount account
	 * 
	 **********************************************************************************/
	@Override
	public boolean editWalletAccount(WalletAccount account) {
		entityManager.merge(account);
		return true;
	}
/**********************************************************************************
	 * 
	 * @Author Name  : lovaraju
	 * Method Name   : getWalletAccount
	 * Description   : gets account instance When accountid is passed
	 * Return Type   : WalletAccount

	  
	 **********************************************************************************/
	@Override
	public WalletAccount getWalletAccount(String walletAccountId) {
		
		return entityManager.find(WalletAccount.class, walletAccountId);
	}

/**********************************************************************************
	 * 
	 * @Author Name  : lovaraju
	 * Method Name   : addWalletTransaction
	 * Description   : add a neW transcation rweq
	 * Return Type   : boolean

	  
	 **********************************************************************************/
	@Override
	public boolean addWalletTransaction(WalletTransaction walletTxn) {
		entityManager.persist(walletTxn);
		return true;
	}

	/**********************************************************************************
	 * 
	 * @Author Name  : venkata sai kumar
	 * Method Name   : getWalletTransactions
	 * Description   : getting transactions of given user's walletUSerId 
	 * Return Type   : List(List of Transactions)
	 * Parameter 1   : String walletUSerId
	 * 
	 **********************************************************************************/
	@Override
	public List<WalletTransaction> getWalletTransactions(String walletUserId) {
		String jpql = "from WalletTransaction walletTransaction inner join fetch walletTransaction.account walletAccount  where walletAccount.phoneNo=:walletUserid";
		TypedQuery<WalletTransaction> query = entityManager.createQuery(jpql, WalletTransaction.class);
		query.setParameter("walletUserid", walletUserId);
		return query.getResultList();
	}

	/**********************************************************************************
	 * 
	 * @Author Name  : venkata sai kumar
	 * Method Name   : getWalletTransactions
	 * Description   : getting number of transactions of given user's walletUSerId 
	 * Return Type   : List(List of Transactions)
	 * Parameter 1   : String walletUSerId
	 * Parameter 2   : int txns
	 * 
	 **********************************************************************************/
	@Override
	public List<WalletTransaction> getWalletTransactions(String walletUserId, int txns) {
		String jpql = "from WalletTransaction walletTransaction inner join fetch walletTransaction.account walletAccount where walletAccount.phoneNo=:walletUserid order by walletTransaction.dateOfTransction desc";
		TypedQuery<WalletTransaction> query = entityManager.createQuery(jpql, WalletTransaction.class);
		query.setFirstResult(1);
		query.setMaxResults(txns);
		query.setParameter("walletUserid", walletUserId);
		return query.getResultList();
	}
	
	/**********************************************************************************
	 * 
	 * @Author Name  : venkata sai kumar
	 * Method Name   : getWalletTransactions
	 * Description   : getting transactions of given user's walletUSerId from fromDtate to toDate
	 * Return Type   : List(List of Transactions)
	 * Parameter 1   : String walletUSerId
	 * Parameter 2   : LocalDate fromDate
	 * Parameter 3   : LocalDate toDate
	 * 
	 **********************************************************************************/
	@Override
	public List<WalletTransaction> getWalletTransactions(String walletUserId, LocalDate fromDt, LocalDate toDate) {
		String jpql = "from WalletTransaction walletTransaction inner join fetch walletTransaction.account walletAccount  "
				+ "where walletAccount.phoneNo=:walletUserid and walletTransaction.dateOfTranscation between :fromdt and :todt ";
		TypedQuery<WalletTransaction> query = entityManager.createQuery(jpql, WalletTransaction.class);
		query.setParameter("walletUserid", walletUserId);
		query.setParameter("fromdt", fromDt);
		query.setParameter("todt", toDate);
		return query.getResultList();
	}

}







