package com.cg.wallet.dto;

public class TransferForm {

	private String fromaccountID;
	private String toAccountID;
	private double amt;
	
	public String getFromaccountID() {
		return fromaccountID;
	}
	public void setFromaccountID(String fromaccountID) {
		this.fromaccountID = fromaccountID;
	}
	public String getToAccountID() {
		return toAccountID;
	}
	public void setToAccountID(String toAccountID) {
		this.toAccountID = toAccountID;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	@Override
	public String toString() {
		return "TransferForm [fromaccountID=" + fromaccountID + ", toAccountID=" + toAccountID + ", amt=" + amt + "]";
	}
	
	
	
	
	
}
