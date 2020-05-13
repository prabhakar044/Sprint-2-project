package com.cg.wallet.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ReportForm {

	private String walletId;
	private String receipentId;
	@DateTimeFormat(pattern="yyyy-M-d")
	private LocalDate fromDt;
	@DateTimeFormat(pattern="yyyy-M-d")
	private LocalDate toDt;
	
	public String getWalletId() {
		return walletId;
	}
	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}
	public String getReceipentId() {
		return receipentId;
	}
	public void setReceipentId(String receipentId) {
		this.receipentId = receipentId;
	}
	public LocalDate getFromDt() {
		return fromDt;
	}
	public void setFromDt(LocalDate fromDt) {
		this.fromDt = fromDt;
	}
	public LocalDate getToDt() {
		return toDt;
	}
	public void setToDt(LocalDate toDt) {
		this.toDt = toDt;
	}
	
	
	
	
}
