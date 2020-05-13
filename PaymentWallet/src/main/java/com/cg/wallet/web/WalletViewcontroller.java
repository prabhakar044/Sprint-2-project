
package com.cg.wallet.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.wallet.dto.ReportForm;
import com.cg.wallet.entity.WalletTransaction;
import com.cg.wallet.exceptions.WalletTXNNotFouException;
import com.cg.wallet.service.ViewWalletService;


/**********************************************************************************
 * 
 * @Author Name  : venkata sai kumar
 * Description   : Dispatcherservlet maps the request to handler method viewtxns
 * 
 **********************************************************************************/
@RestController
public class WalletViewcontroller {

	@Autowired
	private ViewWalletService walletService;
	
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
	@CrossOrigin
	@GetMapping("/getWalletTransactions/{walletid}")
	public List<WalletTransaction> getWalletTransactions(@PathVariable("walletid") String walletUSerId) throws WalletTXNNotFouException{
		return walletService.getWalletTransactions(walletUSerId);
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
	 * @throws       : WalletTXNNotFouException - if number of Transactions is Zero
	 * 
	 **********************************************************************************/
	@CrossOrigin
	@PostMapping("/getWalletTxnsForDateRange")
	public List<WalletTransaction> getWalletTransactions(@RequestBody ReportForm form) throws WalletTXNNotFouException{
			
		return walletService.getWalletTransactions(form.getWalletId(), form.getFromDt(), form.getToDt());
	}
	
	
	/**********************************************************************************
	 * 
	 * @Author Name  : venkata sai kumar
	 * Method Name   : getTxnsFromRecipent
	 * Description   : getting transactions Recived from  recipentID of given user's walletUSerId 
	 * Return Type   : List(List of Transactions)
	 * Parameter 1   : String walletUSerId
	 * Parameter 2   : String recipentID
	 * @throws       : WalletTXNNotFouException - if number of Transactions is Zero
	 * 
	 **********************************************************************************/
	@CrossOrigin
	@GetMapping("/gettxnsrecipentfrom/{walletid}/{receipentid}")
	public List<WalletTransaction> getTxnsFromRecipent(@PathVariable("walletid") String walletUserId, @PathVariable("receipentid") String receipentId) throws WalletTXNNotFouException {
		return walletService.getWalletTransactionsRecievedReceipent(walletUserId, receipentId);
	}
	
	/**********************************************************************************
	 * 
	 * @Author Name  : venkata sai kumar
	 * Method Name   : getTxnsFromRecipentForDateRange
	 * Description   : getting transactions Recived from  recipentID of given user's walletUSerId from fromDtate to toDate
	 * Return Type   : List(List of Transactions)
	 * Parameter 1   : String walletUSerId
	 * Parameter 2   : String recipentID
	 * @throws       : WalletTXNNotFouException - if number of Transactions is Zero
	 * 
	 **********************************************************************************/
	@CrossOrigin
	@PostMapping("/gettxnsrecipentfromdaterange")
	public List<WalletTransaction> getTxnsFromRecipentForDateRange(@RequestBody ReportForm form) throws WalletTXNNotFouException {
		return walletService.getWalletTransactionsReceivedReceipent(form.getWalletId(), form.getReceipentId(), form.getFromDt(), form.getToDt());
	}
	
	
	/**********************************************************************************
	 * 
	 * @Author Name  : venkata sai kumar
	 * Method Name   : getTxnsToRecipent
	 * Description   : getting transactions Transfered from walletUSerId To  recepentID
	 * Return Type   : List(List of Transactions)
	 * Parameter 1   : String walletUSerId
	 * Parameter 2   : String recipentID
	 * @throws       : WalletTXNNotFouException - if number of Transactions is Zero
	 * 
	 **********************************************************************************/
	@CrossOrigin
	@GetMapping("/gettxnsrecipentto/{walletid}/{receipentid}")
	public List<WalletTransaction> getTxnsToRecipent(@PathVariable("walletid") String walletUserId, @PathVariable("receipentid") String receipentId) throws WalletTXNNotFouException {
		return walletService.getWalletTransactionsTransferedToReceipent(walletUserId, receipentId);
	}
	
	
	
	/**********************************************************************************
	 * 
	 * @Author Name  : venkata sai kumar
	 * Method Name   : getTxnsToRecipentForDateRange
	 * Description   : getting transactions Transfered from walletUSerId To  recepentID between fromDt to toDate 
	 * Return Type   : List(List of Transactions)
	 * Parameter 1   : String walletUSerId
	 * Parameter 2   : String recipentID
	 * Parameter 2   : LocalDate fromDate
	 * Parameter 3   : LocalDate toDate
	 * @throws       : WalletTXNNotFouException - if number of Transactions is Zero
	 * 
	 **********************************************************************************/
	@CrossOrigin
	@PostMapping("/gettxnsrecipenttodaterange")
	public List<WalletTransaction> getTxnsToRecipentForDateRange(@RequestBody ReportForm form) throws WalletTXNNotFouException {
		return walletService.getWalletTransactionsTransferedToReceipent(form.getWalletId(), form.getReceipentId(), form.getFromDt(), form.getToDt());
	}
	
	
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
	@CrossOrigin
	@GetMapping("/getWalletTransactions/six/{walletid}")
	public List<WalletTransaction> getWalletSixMonthsTransactions(@PathVariable("walletid") String walletUserId) throws WalletTXNNotFouException{
		return walletService.getSixMonthsTxn(walletUserId);
	}
	
}
