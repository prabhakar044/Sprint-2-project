package com.cg.wallet.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "lpu_wallet_account")
@DynamicUpdate
@DynamicInsert
public class WalletAccount {

	@Id
	@Column(name = "phone_no")
	private String phoneNo;
	@Column(name = "balance")
	private double balance;
	@Column(name = "status")
	private boolean status;
	@Column(name = "user_name", length = 25)
	private String userName;
	@Column(name = "password", length = 10)
	private String password;
	@Column(name = "role", length = 20)
	private String role;
	@Column(name = "acc_created_date")
	private LocalDate accCreatedDt;

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDate getAccCreatedDt() {
		return accCreatedDt;
	}

	public void setAccCreatedDt(LocalDate accCreatedDt) {
		this.accCreatedDt = accCreatedDt;
	}

}
