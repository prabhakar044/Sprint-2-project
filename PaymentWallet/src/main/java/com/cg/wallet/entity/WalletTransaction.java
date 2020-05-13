package com.cg.wallet.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "lpu_wallet_txns")
@DynamicUpdate
@DynamicInsert
public class WalletTransaction {
	
	@Id
	@Column(name = "wallet_txn_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionId;
	
	@Column(name="tx_desc", length=100)
	private String description;
	
	@Column(name="date_of_txn")
	private LocalDate dateOfTranscation;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="tx_type")
	private String txType;
	
	@ManyToOne
	@JoinColumn(name="phone_no" , referencedColumnName = "phone_no")
	public WalletAccount account;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateOfTranscation() {
		return dateOfTranscation;
	}

	public void setDateOfTranscation(LocalDate dateOfTranscation) {
		this.dateOfTranscation = dateOfTranscation;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTxType() {
		return txType;
	}

	public void setTxType(String txType) {
		this.txType = txType;
	}

	public WalletAccount getAccount() {
		return account;
	}

	public void setAccount(WalletAccount account) {
		this.account = account;
	}
	
	
	
	
	
	
	
}


